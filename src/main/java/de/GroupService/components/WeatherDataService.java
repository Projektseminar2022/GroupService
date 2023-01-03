package de.GroupService.components;

import de.GroupService.model.Location;
import de.GroupService.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherDataService {


    public Weather getWeatherData(Location location, int timeInAdvanceInHours) {
        return callApi(location, timeInAdvanceInHours);
    }

    private Weather callApi(Location location, int timeInAdvanceInHours) {
        return new Weather(); //todo fix api call
    }
}
