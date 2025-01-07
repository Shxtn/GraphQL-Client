package edu.fra.uas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.Event;
import edu.fra.uas.service.EventService;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;

@Component
public class InitData {

    private final Logger log = LoggerFactory.getLogger(InitData.class);

    @Autowired
    private EventService eventService;

    @PostConstruct
    public void init() {
        log.debug("### Initialize Calendar Data ###");

        log.debug("Create Event 1: Team Meeting");
        Event event = new Event();
        event.setId("1");
        event.setTitle("Team Meeting");
        event.setDescription("Discuss project progress");
        event.setStartTime(LocalDateTime.of(2025, 1, 10, 10, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 10, 11, 0));
        eventService.addEvent(event);

        log.debug("Create Event 2: Sprint Planning");
        event = new Event();
        event.setId("2");
        event.setTitle("Sprint Planning");
        event.setDescription("Plan the tasks for the next sprint");
        event.setStartTime(LocalDateTime.of(2025, 1, 11, 9, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 11, 10, 30));
        eventService.addEvent(event);

        log.debug("Create Event 3: Client Presentation");
        event = new Event();
        event.setId("3");
        event.setTitle("Client Presentation");
        event.setDescription("Present the project updates to the client");
        event.setStartTime(LocalDateTime.of(2025, 1, 12, 14, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 12, 15, 0));
        eventService.addEvent(event);

        log.debug("Create Event 4: Code Review");
        event = new Event();
        event.setId("4");
        event.setTitle("Code Review");
        event.setDescription("Review the new features implemented");
        event.setStartTime(LocalDateTime.of(2025, 1, 13, 16, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 13, 17, 0));
        eventService.addEvent(event);

        log.debug("Create Event 5: Team Lunch");
        event = new Event();
        event.setId("5");
        event.setTitle("Team Lunch");
        event.setDescription("Enjoy lunch together as a team");
        event.setStartTime(LocalDateTime.of(2025, 1, 14, 12, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 14, 13, 0));
        eventService.addEvent(event);

        log.debug("Create Event 6: Retrospective Meeting");
        event = new Event();
        event.setId("6");
        event.setTitle("Retrospective Meeting");
        event.setDescription("Reflect on the sprint and identify improvements");
        event.setStartTime(LocalDateTime.of(2025, 1, 15, 15, 0));
        event.setEndTime(LocalDateTime.of(2025, 1, 15, 16, 30));
        eventService.addEvent(event);

        log.debug("### Calendar Data Initialized ###");
    }
}
