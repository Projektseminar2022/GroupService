package de.GroupService.controller.rest;

import de.GroupService.components.GroupService;
import de.GroupService.dto.MembershipDTO;
import de.GroupService.model.Group;
import de.GroupService.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupRestController {

    @Autowired
    private GroupService groupService;

    @PostMapping(
            path="/group",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Group> createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }


    @PutMapping(
            path="/group",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Group> updateGroup(@RequestBody Group group){
        return groupService.updateGroup(group);
    }


    @DeleteMapping(
            path="/group",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Void> deleteGroup(@RequestParam UUID groupId){
        return groupService.deleteGroup(groupId);
    }


    @GetMapping(
            path="/group",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Group> getGroup(@RequestParam UUID groupId){
        return groupService.getGroup(groupId);
    }


    @GetMapping(
            path="/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Group> getAllGroups(){
        return groupService.getAllGroups();
    }


    @GetMapping(
            path = "/by-name",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Group> getGroupByName(@RequestParam String name) {
        return groupService.getGroupByName(name);
    }


    @GetMapping(
            path="/by-user",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Group> getGroupsOfAnUser(@RequestParam UUID user){
        return groupService.findGroupsOfUser(user);
    }


    @GetMapping(
            path="/get-random-collection",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Group> getRandomCollectionOfGroups(){
        return groupService.getRandomCollectionOfGroups();
    }


    @GetMapping(
            path="/get-random-collection-by-topic",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Group> getRandomCollectionOfGroups(@RequestParam String topic){
        return groupService.getRandomCollectionOfGroups(topic);
    }


    @GetMapping(path="all-Topics")
    public Flux<Topic> getAllTopics() {
        return groupService.getAllTopics();
    }


    @PostMapping(path = "/joinGroup",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity> joinGroup(@RequestBody MembershipDTO join) {
        return groupService.joinGroup(join);
    }


    @PostMapping(path = "/leaveGroup",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity> leaveGroup(@RequestBody MembershipDTO leave) {
        return groupService.leaveGroup(leave);
    }
}
