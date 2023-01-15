package de.GroupService.components.client;


import feign.Param;
import feign.RequestLine;

public interface NotificationClient {
        @RequestLine("POST /notify/private/")
        void sendPrivateNotification(@Param("userLocationDTO") String message, String recievingUser);
}
