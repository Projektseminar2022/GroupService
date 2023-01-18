package de.GroupService.dto;

import de.GroupService.model.Location;
import de.GroupService.model.Weather;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

public class WeatherDTO {
        double longitude;
        double latitude;
        String expectedFor;
        String lastUpdate;
        WeatherInside weather;

        @Data
        class WeatherInside {
            int dt;
            double temp;
            double feels_like;
            int pressure;
            int humidity;
            double dew_point;
            double uvi;
            int clouds;
            int visibility;
            double wind_speed;
            double wind_deg;
            double wind_gust;
            WeatherDetail[] weather;
            double pop;
            Rain rain;

            @Data
            static
            class WeatherDetail {
                int id;
                String main;
                String description;
                String icon;
            }

            @Data
            static
            class Rain {
                double oneHour;
            }
    }
    public Weather toWeather() {
        return new Weather(new Location(this.longitude, this.latitude),
                Date.from(Instant.now()), this.weather.temp,
                this.weather.wind_speed, this.weather.humidity, this.weather.rain.oneHour);
    }
}
