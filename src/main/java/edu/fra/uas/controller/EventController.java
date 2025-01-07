package edu.fra.uas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import edu.fra.uas.model.Event;
import edu.fra.uas.service.EventService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SchemaMapping(typeName = "Event")
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    // Fetch all events
    @QueryMapping(name = "allEvents")
    public List<Event> getAllEvents() {
        log.debug("getAllEvents() is called");
        return new ArrayList<>(eventService.getAllEvents());
    }

    // Fetch a specific event by ID
    @QueryMapping(name = "eventById")
    public Event getEventById(@Argument String id) {
        log.debug("getEventById() is called with id: " + id);
        return eventService.getEventById(id);
    }

    // Add a new event
    @MutationMapping(name = "addEvent")
    public Event addEvent(
        @Argument String id,
        @Argument String title,
        @Argument String description,
        @Argument String startTime,
        @Argument String endTime
    ) {
        log.debug("addEvent() is called");
        Event event = new Event();
        event.setId(id);
        event.setTitle(title);
        event.setDescription(description);
        event.setStartTime(LocalDateTime.parse(startTime));
        event.setEndTime(LocalDateTime.parse(endTime));
        return eventService.addEvent(event);
    }

    // Update an existing event
    @MutationMapping(name = "updateEvent")
    public Event updateEvent(
        @Argument String id,
        @Argument String title,
        @Argument String description,
        @Argument String startTime,
        @Argument String endTime
    ) {
        log.debug("updateEvent() is called with id: " + id);
        Event event = eventService.getEventById(id);
        if (event == null) {
            log.error("Event with id " + id + " not found");
            return null;
        }
        if (title != null && !title.isEmpty()) {
            event.setTitle(title);
        }
        if (description != null && !description.isEmpty()) {
            event.setDescription(description);
        }
        if (startTime != null && !startTime.isEmpty()) {
            event.setStartTime(LocalDateTime.parse(startTime));
        }
        if (endTime != null && !endTime.isEmpty()) {
            event.setEndTime(LocalDateTime.parse(endTime));
        }
        return eventService.addEvent(event);
    }

    // Delete an event
    @MutationMapping(name = "deleteEvent")
    public Boolean deleteEvent(@Argument String id) {
        log.debug("deleteEvent() is called with id: " + id);
        Event event = eventService.removeEvent(id);
        if (event == null) {
            log.error("Event with id " + id + " not found");
            return false;
        } else {
            log.debug("Event with id " + id + " deleted");
            return true;
        }
    }
}
