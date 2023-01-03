package de.GroupService.components;

import com.google.common.collect.Lists;
import dto.UserWithGroupsDTO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


//@Service TODO Sinnvoll ?
@Slf4j
public class ConditionGuard extends Thread { //TODO make it singleton

    private int numberOfUserPerThread = 100000;
    @Autowired
    ConditionService conditionService;

    public void run() {

        while(true) {
            var userWithGroupsList = getUserAndTheirGroups(); //fetch fresh data
            var numberOfThreads = (userWithGroupsList.size() / numberOfUserPerThread) + 1;
            ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
            var dataForThreads = Lists.partition(userWithGroupsList, numberOfThreads);
            List<Runnable> tasks = dataForThreads.stream().map(CheckConditionJob::new).collect(Collectors.toList());
            CompletableFuture<?>[] futures = tasks.stream()
                                                  .map(task -> CompletableFuture.runAsync(task, es))
                                                  .toArray(CompletableFuture[]::new);
            CompletableFuture.allOf(futures).join();
        }

    }


    private List<UserWithGroupsDTO> getUserAndTheirGroups() {
        var result = new ArrayList<UserWithGroupsDTO>();
        return result; //TODO get user with his groups that are not  timedout
    }

    private class CheckConditionJob implements Runnable {

        private List<UserWithGroupsDTO> userAndTheirGroups;

        public CheckConditionJob(List<UserWithGroupsDTO> userAndTheirGroups) {
            this.userAndTheirGroups = userAndTheirGroups;
        }

        public void run() {
            for(var userAndHisGroups : userAndTheirGroups) {
                conditionService.checkConditions(userAndHisGroups.getUser(), userAndHisGroups.getGroups());
            }
        }
    }
}
