package de.GroupService.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SendNotifications {
    UUID groupId;
    LocalDateTime timeSend;
    LocalDateTime coolDownTill;
}
