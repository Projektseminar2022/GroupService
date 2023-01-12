package de.GroupService.components;

import de.GroupService.dto.UserLocationDTO;
import de.GroupService.model.Weather;
import feign.Param;
import feign.RequestLine;

public interface WeatherClient {
    @RequestLine("GET /query/find-by-user/")
    Weather findByLocationAndTimeInAdvanceInHours(@Param("userLocationDTO") UserLocationDTO userLocationDTO);
}
