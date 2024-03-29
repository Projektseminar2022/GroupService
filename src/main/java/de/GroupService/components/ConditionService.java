package de.GroupService.components;


import de.GroupService.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class ConditionService {

    @Autowired
    private UserService userService;
    private final CallNotificationService notificationService;
    private WeatherDataService weatherService;


    @Autowired
    public ConditionService(CallNotificationService service, WeatherDataService weatherService) {
        this.notificationService = service;
        this.weatherService = weatherService;
    }


    public Flux<Object> checkConditions(User user, List<Group> groups) {
        return Flux.fromStream(groups.stream().filter(group -> checkConditions(user, group) )
                .map(group -> sendNotification(user, group)));
    }


    private boolean sendNotification(User user, Group group) {
        try {
            notificationService.callNotification(this.message() + group.getMessage(), user.getId());
            userService.addNotifcationCoolDown(user, new SendNotificationsToUser(group.getId(), LocalDateTime.now(), LocalDateTime.now())); // todo add time to cooldown
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private String message() {
        return "GroupService: ";
    }


    private boolean checkConditions(User user, Group group) {
        Condition condition = group.getCondition();
        var lastNotifications = user.getSendNotifications();
        var notificationsForGroup = lastNotifications.stream().filter(sendNotifications -> sendNotifications.getGroupId().equals(group.getId()));
        AtomicBoolean isOnCooldown = new AtomicBoolean(false);
         notificationsForGroup.forEach(notification -> {
           if( notification.getCoolDownTill().isBefore(LocalDateTime.now())) {
               isOnCooldown.set(true);
           }
        });
        if(isOnCooldown.get()) {
            return false;
        }
        Weather weather = this.getWeather(group.getLocation().getLatitude(), group.getLocation().getLongitude(), group.getHoursBeforeNotification());
        if(!condition.getTemperatureInC().contains((int) weather.getTemperatureInC())) {
            return false;
        }
        if(!condition.getWindInKmH().contains((int) weather.getWindInKmH())) {
            return false;
        }
        if(!condition.getHumidityInPerCent().contains((int) weather.getHumidityInPerCent())) {
            return false;
        }
        if(!condition.getPrecipitationInMm().contains((int) weather.getPrecipitationInMm())) {
            return false;
        }
        return true;
    }


    private Weather getWeather(double latitude, double longitude, int timeInAdvanceInHours) {
        return this.weatherService.getWeatherData(latitude, longitude, timeInAdvanceInHours);
    }
}
