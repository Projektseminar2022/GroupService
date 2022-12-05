package de.GroupService.components;

import de.GroupService.model.Location;
import de.GroupService.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherDataService {
    private Map<Location, Weather> weatherData = new HashMap<>();



    public Weather getWeatherData(Location location) {
        if(weatherData.containsKey(location) && weatherData.get(location).notTimedout()) {
            return weatherData.get(location);
        }
        Weather retrievedData = this.callApi(location);
        weatherData.put(location, retrievedData);
        return retrievedData;
    }

    private Weather callApi(Location location) {
        return new Weather(); //todo fix api call
    }
}
