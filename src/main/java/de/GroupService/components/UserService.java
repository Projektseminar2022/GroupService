package de.GroupService.components;

import de.GroupService.model.Location;
import de.GroupService.model.User;
import de.GroupService.model.repositories.GroupRepository;
import de.GroupService.model.repositories.UserRepository;
import dto.UserWithGroupsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Location getLocationOfUser(User user) {
        return new Location("");
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
