package de.GroupService.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;
//import java.awt.Image;

@Data
public class Group {

    private UUID id;
    private Integer creator;
    private List<Integer> members;
    private Topic topic;
    private Condition condition;
    private Integer minutesBeforeNotification;
    //private Image image;


}
