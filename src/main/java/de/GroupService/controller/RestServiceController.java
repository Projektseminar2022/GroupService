package de.GroupService.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class RestServiceController {


    @GetMapping(
            path = "/hello",
            produces = { MediaType.TEXT_PLAIN_VALUE }
    )
    public Mono<String> simpleHelloWorldWithGet(@RequestParam String name) {



        return Mono.just("Hello " + name);
    }

    @PostMapping(
            path = "/hello",
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.TEXT_PLAIN_VALUE }
    )
    public Mono<String> helloWorldWithPost(@RequestBody String name) {



        return Mono.just("Hello " + name);
    }
}