package de.GroupService.model.repositories;

import de.GroupService.model.Group;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import java.util.UUID;


public interface GroupRepository extends ReactiveCrudRepository<Group, UUID> {
}
