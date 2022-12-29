package de.GroupService.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class CallNotificationService {

//    @Bean
//    public WebClient localApiClient() {
//        return WebClient.create("???"); //todo fix
//    }

    private final WebClient localApiClient;

    public CallNotificationService() {
        this.localApiClient =  WebClient.create();
//    localApiClient;
    }

    //todo make call with correct body
    public boolean callNotification(String message, long userId) {
        try {
            //TODO RESOLVE function call
//            LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap();
//            map.add("userId", userId); //todo api checken
//            map.add("message", message);
//            ResponseEntity<?> response = localApiClient.post().
//            body(BodyInserters.fromMultipartData(map)).retrieve().toEntity().block();
//            if(response.getStatusCodeValue() == 200) {
//                return true;
//            }
//            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
