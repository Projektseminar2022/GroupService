package de.GroupService.components.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherClient", url = "localhost:1234")
public interface WeatherClient {

    @GetMapping("/controller/GetWeatherForecast/")
    Object getWeather(@RequestParam(value="latitude") double latitude, @RequestParam(value="longitude") double longitude);
}
