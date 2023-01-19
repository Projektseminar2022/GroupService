package de.GroupService.components;

import de.GroupService.components.client.WeatherClient;
import de.GroupService.model.Weather;
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
        return weatherDataClient.getWeatherByCoordinatesAndTimeInAdvance(latitude, longitude, timeInAdvanceInHours).toWeather();
    }
}