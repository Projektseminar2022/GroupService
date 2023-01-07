package de.GroupService.components;


import de.GroupService.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.*;

@Service
public class ConditionService {

    private final CallNotificationService notificationService;

    private WeatherDataService weatherService;

    @Autowired
    private UserService userService;

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
        Weather weather = this.getWeather(this.getLocationOfUser(user), group.getHoursBeforeNotification());
        if(!condition.getTemperatureInC().contains(weather.getTemperatureInC())) {
            return false;
        }
        if(!condition.getWindInKmH().contains(weather.getWindInKmH())) {
            return false;
        }
        if(!condition.getSnowInCm().contains(weather.getSnowInCm())) {
            return false;
        }
        if(!condition.getHumidityInPerCent().contains(weather.getHumidityInPerCent())) {
            return false;
        }
        if(!condition.getPrecipitationInMm().contains(weather.getPrecipitationInMm())) {
            return false;
        }
        return true;
    }

    private Weather getWeather(Location location, int timeInAdvanceInHours) {
        return this.weatherService.getWeatherData(location, timeInAdvanceInHours);
    }

    private Location getLocationOfUser(User user) {
        return this.userService.getLocationOfUser(user);
    }

}
