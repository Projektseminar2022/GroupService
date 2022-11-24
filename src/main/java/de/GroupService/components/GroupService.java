package de.GroupService.components;

import de.GroupService.model.Group;
import de.GroupService.model.Topic;
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
        var group = new Group();
        group.setId(groupId);
        return groupRepo.delete(group);
    }

    public Mono<Group> getGroup(UUID groupId) {
        return groupRepo.findById(groupId);
    }

    public Flux<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    public Flux<Group> findByUser(UUID user) {
        return findByUser(user);
    }

    public Flux<Group> getRandomCollectionOfGroups() {
        return randomCollectionOfGroups(); //TODO implement custom
    }

    public Flux<Group> getRandomCollectionOfGroups(String topic) {
        return randomCollectionOfGroups(Topic.valueOf(topic)); //TODO implement custom
    }
}
