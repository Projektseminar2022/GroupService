package de.GroupService.components;


import de.GroupService.model.Condition;
import de.GroupService.model.Group;
import de.GroupService.model.Location;
import de.GroupService.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ConditionService {

    private final CallNotificationService notificationService;

    private WeatherDataService weatherService;

    @Autowired
    public ConditionService(CallNotificationService service, WeatherDataService weatherService) {
        this.notificationService = service;
        this.weatherService = weatherService;
    }

    public Flux<Object> checkConditions(List<Group> groups) {
        return Flux.fromStream(groups.stream().filter(group -> needToNotificate(group)).filter(group -> checkConditions(group) )
                .map(group -> sendNotification(group)));
    }

    private boolean sendNotification(Group group) {
        try {
            group.getMembers().stream().map(id -> notificationService.callNotification(this.message(), id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String message() {
        return "condition met"; //todo add custom message
    }

    private boolean needToNotificate(Group group) {
        return group.getLastNotificationSend().after(Date.from(Instant.now()
                .plusSeconds( TimeUnit.MINUTES.toSeconds( 5 ) )));
    }
    private boolean checkConditions(Group group) {
        Condition condition = group.getCondition();
        Weather weather = this.getWeather(group.getLocation());
        if(condition.getTemperatureInC().contains(weather.getTemperatureInC())) {
            return true;
        }
        if(condition.getWindInKmH().contains(weather.getWindInKmH())) {
            return true;
        }
        if(condition.getSnowInCm().contains(weather.getSnowInCm())) {
            return true;
        }
        if(condition.getHumidityInPerCent().contains(weather.getHumidityInPerCent())) {
            return true;
        }
        if(condition.getPrecipitationInMm().contains(weather.getPrecipitationInMm())) {
            return true;
        }
        return false;
    }

    private Weather getWeather(Location location) {
        return this.weatherService.getWeatherData(location);
    }

}
