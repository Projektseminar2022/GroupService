package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private UUID id;
	private ArrayList<UUID> groups;
	private Location location;
    private String name;
    private ArrayList<SendNotificationsToUser> sendNotifications;

}
