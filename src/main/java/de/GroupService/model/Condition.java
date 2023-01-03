package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class Condition {

    private Range temperatureInC;
    private Range windInKmH;
    private Range snowInCm;
    private Range humidityInPerCent;
    private Range precipitationInMm; //Niederschlag
    //TODO tbc


    @Data
    public class Range {
        int max;
        int min;

        public Range() { //lombok constructor generating not properly working when using inner class

        }

        public boolean contains(int value) {
            return value >= this.min && value <= this.max;
        }
    }
}
