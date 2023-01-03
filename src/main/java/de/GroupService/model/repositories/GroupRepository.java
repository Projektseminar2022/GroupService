package de.GroupService.model.repositories;

import de.GroupService.model.Group;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import java.util.UUID;

public interface GroupRepository extends ReactiveMongoRepository<Group, UUID> {
}
