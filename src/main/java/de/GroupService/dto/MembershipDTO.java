package de.GroupService.dto;

import de.GroupService.model.Group;
import de.GroupService.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDTO {
    User user;
    Group group;
}
