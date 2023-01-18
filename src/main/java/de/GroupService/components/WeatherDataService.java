package de.GroupService.components;

import de.GroupService.components.client.WeatherClient;
import de.GroupService.model.Weather;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherDataService {

    @Autowired
    private WeatherClient weatherDataClient;
    public WeatherDataService() {

    }


    public Weather getWeatherData(double latitude, double longitude, int timeInAdvanceInHours) {
        return callApi(latitude, longitude, timeInAdvanceInHours);
    }

    private Weather callApi(double latitude, double longitude, int timeInAdvanceInHours) {
        Weather weather;

        return weatherDataClient.getWeatherByCordinates(latitude, longitude).toWeather();
        //TODO das was da ankommt irgendwie zu einem Wetterobjekt machen das auf timeInAdvanceInHours matcht
    }
}
