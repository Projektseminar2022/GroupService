package de.GroupService.components;

import de.GroupService.components.client.NotificationClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CallNotificationService {
    private final NotificationClient weatherDataClient;
    public CallNotificationService() {
            this.weatherDataClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(NotificationClient.class, "http://localhost:8081/api/books"); //todo add real url
        }

    public boolean callNotification(String message, UUID userId) {
        try {
            weatherDataClient.sendPrivateNotification(message, userId.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
