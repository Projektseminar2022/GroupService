package de.GroupService.model.repositories;

import de.GroupService.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface UserRepository extends ReactiveMongoRepository<User, UUID> {
}
