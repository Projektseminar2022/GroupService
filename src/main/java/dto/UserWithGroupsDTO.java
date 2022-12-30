package dto;

import de.GroupService.model.Group;
import de.GroupService.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class UserWithGroupsDTO {
    private User user;
    private List<Group> groups;

    public UserWithGroupsDTO(User user, List<Group> groups) {
        this.user = user;
        this.groups = groups;
    }
}
