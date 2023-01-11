package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    private UUID id;
    private Integer creator;
    private Location location;
    private List<UUID> members;
    private List<Topic> topic;
    private Condition condition;
    private Integer hoursBeforeNotification;
    private Date lastNotificationSend;
    private String message;

}
