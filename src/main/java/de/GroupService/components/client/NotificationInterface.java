package de.GroupService.components.client;

import de.GroupService.dto.NotificationDTO;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotificationInterface {
    @RequestLine("POST /*/private")
    void notifyUser(@RequestBody NotificationDTO notificationDTO);
}
