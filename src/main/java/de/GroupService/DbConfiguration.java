package de.GroupService;

import de.GroupService.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.r2dbc.core.DatabaseClient;

import lombok.extern.slf4j.Slf4j;



/**
 *
 *	this configuration class contains methods to be called upon
 *	start or context changes of the deployed service
 *
 */
@Configuration
@Slf4j
public class DbConfiguration {

    // we get the database client from the framework
    // it is ready to use
    @Autowired
    private DatabaseClient dbClient;

    // we create an event listener which is called upon
    // context changes
    @EventListener
    public void contextEvent(ContextRefreshedEvent event) {
        log.debug("Checking data base connection and tables");
        configureDB();
    }


    // this method contains everything to create our first table
    // alternatively, it could have been implemented as a bean
    //
    // Beans are also created at startup and the result stored
    // in the framework
    //
    public void configureDB(){
//        log.debug("Trying to create tables");
//
//        dbClient.sql( Group.sqlCreate ).fetch().rowsUpdated()
//                .map( l -> {
//                    log.debug("Rows updated {}",l);
//                    return l;
//                }).subscribe();

    }
}
