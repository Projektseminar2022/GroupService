package de.GroupService.components;

import com.google.common.collect.Lists;
import de.GroupService.dto.UserWithGroupsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


@Component
@Slf4j
public class ConditionJob {

    final int CHECKING_PERIOD_IN_milliseconds = 1800000; //1800000 milliseconds are 30 minutes
    final int NUMBER_OF_TASKS_PER_THREAD = 100000;

    @Autowired
    ConditionService conditionService;
    @Autowired
    UserService userService;

    //@Scheduled(cron = "0/5 * * * * ?") //every five seconds
    @Scheduled(fixedRate=CHECKING_PERIOD_IN_milliseconds)
    private void executePeriodically() {

        var userWithGroupsList = getUserAndTheirGroups(); //fetch fresh data
        var numberOfThreads = Math.min((userWithGroupsList.size() / NUMBER_OF_TASKS_PER_THREAD) + 1, 100);
        ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
        var dataForThreads = Lists.partition(userWithGroupsList, numberOfThreads);
        List<Runnable> tasks = dataForThreads.stream().map(CheckConditionJob::new).collect(Collectors.toList());
        System.out.println("start");
        CompletableFuture<?>[] futures = tasks.stream()
                                                  .map(task -> CompletableFuture.runAsync(task, es))
                                                  .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        System.out.println("end");
    }

    private List<UserWithGroupsDTO> getUserAndTheirGroups() {
        var result = new ArrayList<UserWithGroupsDTO>();
        result = new ArrayList<>(userService.getUsersWithGroups());
        return result;
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
