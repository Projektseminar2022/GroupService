package de.GroupService.components;

import de.GroupService.model.Condition;
import de.GroupService.model.Group;
import de.GroupService.model.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DeferredImportSelector;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest {

    @Autowired
    GroupService groupService;

    @Test
    void createGroup() {
        Group group = new Group(null,1321, new ArrayList<>(), Topic.Sport , new Condition(),99);
        groupService.createGroup(group);
    }

    @Test
    void updateGroup() {
    }

    @Test
    void deleteGroup() {
    }

    @Test
    void getGroup() {
    }

    @Test
    void getAllGroups() {
    }

    @Test
    void findByUser() {
    }

    @Test
    void getRandomCollectionOfGroups() {
    }

    @Test
    void testGetRandomCollectionOfGroups() {
    }
}