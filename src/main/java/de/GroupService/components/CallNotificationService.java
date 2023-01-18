package de.GroupService.components;

import de.GroupService.components.client.NotificationClient;
import de.GroupService.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CallNotificationService {

    @Autowired
    private NotificationClient notificationClient;
    public CallNotificationService() {

    }

    public boolean callNotification(String message, UUID userId) {
        try {
            notificationClient.notifyUser(new NotificationDTO(message, userId.toString()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
