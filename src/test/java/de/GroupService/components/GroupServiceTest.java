package de.GroupService.components;

import de.GroupService.model.Condition;
import de.GroupService.model.Group;
import de.GroupService.model.Location;
import de.GroupService.model.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DeferredImportSelector;

import java.util.AbstractList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupServiceTest {

    @Autowired
    GroupService groupService;

    @Test
    void createGroup() {
        Group group = new Group();
        var erg = groupService.createGroup(group);
        var groups = groupService.getAllGroups().toIterable();
        groups.forEach((group1 -> System.out.println(group1)));

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