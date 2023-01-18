package de.GroupService.components.client;

import de.GroupService.dto.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "NotificationClient", url = "localhost:1234")
public interface NotificationClient {
    @PostMapping("/*/private")
    void notifyUser(@RequestBody NotificationDTO notificationDTO);
}
