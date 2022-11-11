package de.GroupService.model;

import lombok.Data;
import org.apache.commons.lang3.Range;


@Data
public class Condition {

    private Range<Integer> temperatureInC;
    private Range<Integer> windInKmH;
    private Range<Integer> snowInCm;
    private Range<Integer> humidityInPerCent;
    private Range<Integer> precipitationInMm; //Niederschlag
    //TODO tbc
}
