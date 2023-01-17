package de.GroupService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private String messageContent;
    private String to;
}

// AS JSON { messageContent: msg, to: username }
