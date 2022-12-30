package de.GroupService.components;

import de.GroupService.model.Group;
import de.GroupService.model.repositories.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class GroupService {

    @Autowired
    private GroupRepository groupRepo;

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
        return groupRepo.findAll(); //TODO howmany to return?
    }

    public Flux<Group> getRandomCollectionOfGroups(String topic) {
        return groupRepo.findAll().filter((group -> group.getTopic().contains(topic)));  //randomCollectionOfGroups(Topic.valueOf(topic)); //TODO implement custom
    }
}
