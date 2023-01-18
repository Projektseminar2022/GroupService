package de.GroupService.components;

import de.GroupService.components.client.WeatherClient;
import de.GroupService.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherDataService {

    @Autowired
    public WeatherClient weatherDataClient;

    public WeatherDataService() {

    }


    public Weather getWeatherData(double latitude, double longitude, int timeInAdvanceInHours) {
        return callApi(latitude, longitude, timeInAdvanceInHours);
    }

    private Weather callApi(double latitude, double longitude, int timeInAdvanceInHours) {
        Weather weather;

        Object object = weatherDataClient.getWeatherByCordinates(latitude, longitude);

        //TODO das was da ankommt irgendwie zu einem Wetterobjekt machen das auf timeInAdvanceInHours matcht


        return new Weather();
    }
}
