package edu.fra.uas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.fra.uas.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the service for managing events.
 */
@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    // Internal storage for events (simulating a repository)
    private final Map<String, Event> eventRepository = new HashMap<>();

    /**
     * Adds a new event to the repository.
     *
     * @param event The event to be added.
     * @return The added event.
     */
    public Event addEvent(Event event) {
        log.debug("addEvent: " + event);
        eventRepository.put(event.getId(), event);
        return eventRepository.get(event.getId());
    }

    /**
     * Retrieves all events.
     *
     * @return A collection of all events.
     */
    public Collection<Event> getAllEvents() {
        log.debug("getAllEvents");
        return eventRepository.values();
    }

    /**
     * Retrieves an event by its ID.
     *
     * @param id The ID of the event.
     * @return The event, or null if not found.
     */
    public Event getEventById(String id) {
        log.debug("getEventById: " + id);
        return eventRepository.get(id);
    }

    /**
     * Updates an existing event.
     *
     * @param event The event with updated data.
     * @return The updated event.
     */
    public Event updateEvent(Event event) {
        log.debug("updateEvent: " + event);
        if (eventRepository.containsKey(event.getId())) {
            eventRepository.put(event.getId(), event);
            return eventRepository.get(event.getId());
        } else {
            log.error("Event with id " + event.getId() + " not found for update");
            return null;
        }
    }

    /**
     * Deletes an event by its ID.
     *
     * @param id The ID of the event to be deleted.
     * @return The deleted event, or null if not found.
     */
    public Event removeEvent(String id) {
        log.debug("removeEvent: " + id);
        return eventRepository.remove(id);
    }
}
