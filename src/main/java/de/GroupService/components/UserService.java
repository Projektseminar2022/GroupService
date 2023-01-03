package de.GroupService.components;

import de.GroupService.model.Location;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Location getLocationOfUser() {
        return new Location("");
    }
}
