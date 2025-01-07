package edu.fra.uas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import edu.fra.uas.model.Event;
import edu.fra.uas.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    // Fetch all events
    @QueryMapping
    public List<Event> getAllEvents() {
        log.info("Fetching all events");
        return eventService.getAllEvents().stream().toList();
    }

    // Fetch a specific event by ID
    @QueryMapping
    public Event getEventById(@Argument String id) {
        log.info("Fetching event by ID: {}", id);
        Event event = eventService.getEventById(id);
        if (event == null) {
            log.warn("Event with ID {} not found", id);
        }
        return event;
    }

    // Add a new event
    @MutationMapping
    public Event addEvent(
        @Argument String id,
        @Argument String title,
        @Argument String description,
        @Argument String startTime,
        @Argument String endTime
    ) {
        log.info("Adding new event with ID: {}", id);
        Event event = new Event(id, title, description, LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
        return eventService.addEvent(event);
    }

    // Update an existing event
    @MutationMapping
    public Event updateEvent(
        @Argument String id,
        @Argument String title,
        @Argument String description,
        @Argument String startTime,
        @Argument String endTime
    ) {
        log.info("Updating event with ID: {}", id);
        Event event = new Event(id, title, description, LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
        return eventService.updateEvent(event);
    }

    // Delete an event
    @MutationMapping
    public Boolean deleteEvent(@Argument String id) {
        log.info("Deleting event with ID: {}", id);
        boolean deleted = eventService.removeEvent(id) != null;
        if (!deleted) {
            log.warn("Failed to delete event with ID {}", id);
        }
        return deleted;
    }
}
