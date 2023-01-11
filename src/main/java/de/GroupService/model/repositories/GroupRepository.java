package de.GroupService.model.repositories;

import de.GroupService.model.Group;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GroupRepository extends ReactiveMongoRepository<Group, UUID> {
    Mono<Group> findByName(String name);
}
