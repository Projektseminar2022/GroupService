package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SendNotificationsToUser {
    UUID groupId;
    LocalDateTime timeSend;
    LocalDateTime coolDownTill;
}
