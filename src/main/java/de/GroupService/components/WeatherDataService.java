package de.GroupService.components;

import de.GroupService.dto.UserLocationDTO;
import de.GroupService.model.Location;
import de.GroupService.model.Weather;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class WeatherDataService {

    private final WeatherClient weatherDataClient;
    public WeatherDataService() {
        this.weatherDataClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://localhost:8081/api/books");
    }


    public Weather getWeatherData(String location, int timeInAdvanceInHours) {
        return callApi(location, timeInAdvanceInHours);
    }

    private Weather callApi(String location, int timeInAdvanceInHours) {



        return weatherDataClient.findByLocationAndTimeInAdvanceInHours(new UserLocationDTO(location,
                LocalDateTime.from(Instant.now().plusSeconds(60*60*timeInAdvanceInHours))));
    }
}
