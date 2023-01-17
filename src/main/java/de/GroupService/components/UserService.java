package de.GroupService.components;

import de.GroupService.model.Location;
import de.GroupService.model.User;
import de.GroupService.model.repositories.GroupRepository;
import de.GroupService.model.repositories.UserRepository;
import de.GroupService.dto.UserWithGroupsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //todo optimize possible to use maps?
    public List<UserWithGroupsDTO> getUsersWithGroups() {
        var users = userRepository.findAll();
        var groups = (groupRepository.findAll()).toStream().toList();
        var userWithGroups = users.toStream().map(user -> new UserWithGroupsDTO(user, groups.stream().filter(group ->
        {
            return group.getMembers().contains(user.getId());
        }).toList()));
        return userWithGroups.toList();
    }
}
