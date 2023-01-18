package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class Weather {
    private Location location;
    private Date timesOutAt;
    private double temperatureInC;
    private double windInKmH;
    private double humidityInPerCent;
    private double precipitationInMm;

    public boolean notTimedout() {
        return Date.from(Instant.now()).after(timesOutAt);
    }
}
