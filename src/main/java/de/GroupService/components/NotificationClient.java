package de.GroupService.components;

import de.GroupService.dto.UserLocationDTO;
import de.GroupService.model.Weather;
import feign.Param;
import feign.RequestLine;

public interface NotificationClient {
        @RequestLine("POST /notify/private/")
        void sendPrivateNotification(@Param("userLocationDTO") String message, String recievingUser);
}
