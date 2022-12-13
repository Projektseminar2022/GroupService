package dto;

import de.GroupService.model.Group;

import java.util.List;

public class UserWithGroupsDTO {
    private String user;
    private List<Group> groups;

    public UserWithGroupsDTO(String user, List<Group> groups) {
        this.user = user;
        this.groups = groups;
    }
}
