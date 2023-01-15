package de.GroupService.components;

import de.GroupService.components.client.WeatherClient;
import de.GroupService.model.Weather;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.stereotype.Service;


@Service
public class WeatherDataService {

    private final WeatherClient weatherDataClient;
    public WeatherDataService() {
        this.weatherDataClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://localhost:8081/api/books");  //TODO so überarbeiten dass es mit WeatherClient zusammen passt
    }


    public Weather getWeatherData(double latitude, double longitude, int timeInAdvanceInHours) {
        return callApi(latitude, longitude, timeInAdvanceInHours);
    }

    private Weather callApi(double latitude, double longitude, int timeInAdvanceInHours) {
        Weather weather;

        Object object = weatherDataClient.getWeather(latitude, longitude);

        //TODO das was da ankommt irgendwie zu einem Wetterobjekt machen das auf timeInAdvanceInHours matcht


        return new Weather();
    }
}
