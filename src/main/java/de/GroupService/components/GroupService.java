package de.GroupService.components;

import de.GroupService.dto.joinGroupDTO;
import de.GroupService.model.Group;
import de.GroupService.model.Topic;
import de.GroupService.model.repositories.GroupRepository;
import de.GroupService.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class GroupService {

    @Autowired
    private GroupRepository groupRepo;
    @Autowired
    private UserRepository userRepo;

    public Mono<Group> createGroup(Group group) {
        return groupRepo.save(group);
    }

    public Mono<Group> updateGroup(Group group) {
        return groupRepo.save(group);
    }

    public Mono<Void> deleteGroup(UUID groupId) {
        return groupRepo.deleteById(groupId);
    }

    public Mono<Group> getGroup(UUID groupId) {
        return groupRepo.findById(groupId);
    }

    public Flux<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    public Flux<Group> findGroupsOfUser(UUID userId) {
        return groupRepo.findAll().filter((group -> group.getMembers().contains(userId)));
    }

    public Flux<Group> getRandomCollectionOfGroups() {
        return groupRepo.findAll().take(10);
    }

    public Flux<Group> getRandomCollectionOfGroups(String topic) {
        return groupRepo.findAll().filter(g -> g.getTopic().contains(topic)).take(10);
    }

    public Mono<ResponseEntity> joinGroup(joinGroupDTO join) {
        try {
            //todo check if user is in group?
            var group = groupRepo.findById(join.getGroup().getId()).block();
            var user = userRepo.findById(join.getUser().getId()).block();
            if(!group.equals(null)) {
                return Mono.just(ResponseEntity.badRequest().build());
            }
            if(!user.equals(null)) {
                return Mono.just(ResponseEntity.badRequest().build());
            }
            // request is valid
            group.getMembers().add(user.getId());
            user.getGroups().add(group.getId());
            //todo error handling when 1 save fails?
            userRepo.save(user);
            groupRepo.save(group);
            return Mono.just(ResponseEntity.ok().build());
        } catch (Exception e) {
            //todo log error?
            return Mono.just(ResponseEntity.internalServerError().build());
        }
    }

    public Mono<ResponseEntity> leaveGroup(joinGroupDTO leave) {
        try {
            //todo check if user is in group?
            var group = groupRepo.findById(leave.getGroup().getId()).block();
            var user = userRepo.findById(leave.getUser().getId()).block();
            if(!group.equals(null)) {
                return Mono.just(ResponseEntity.badRequest().build());
            }
            if(!user.equals(null)) {
                return Mono.just(ResponseEntity.badRequest().build());
            }
            // request is valid
            group.getMembers().remove(user.getId());
            user.getGroups().remove(group.getId());
            //todo error handling when 1 save fails?
            userRepo.save(user);
            groupRepo.save(group);
            return Mono.just(ResponseEntity.ok().build());
        } catch (Exception e) {
            //todo log error?
            return Mono.just(ResponseEntity.internalServerError().build());
        }
    }

    public Flux<Topic> getAllTopics() { //TODO REST-Methode machen die diese Methode aufruft
        return Flux.just(Topic.values());
    }
}
