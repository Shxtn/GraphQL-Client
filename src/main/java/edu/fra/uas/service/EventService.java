package edu.fra.uas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.fra.uas.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    // Simulated repository
    private final Map<String, Event> eventRepository = new HashMap<>();

    public Event addEvent(Event event) {
        log.info("Adding event: {}", event);
        eventRepository.put(event.getId(), event);
        return eventRepository.get(event.getId());
    }

    public Collection<Event> getAllEvents() {
        log.info("Fetching all events");
        return eventRepository.values();
    }

    public Event getEventById(String id) {
        log.info("Fetching event with ID: {}", id);
        return eventRepository.get(id);
    }

    public Event updateEvent(Event event) {
        log.info("Updating event: {}", event);
        if (eventRepository.containsKey(event.getId())) {
            eventRepository.put(event.getId(), event);
            return eventRepository.get(event.getId());
        } else {
            log.warn("Event with ID {} not found for update", event.getId());
            return null;
        }
    }

    public Event removeEvent(String id) {
        log.info("Removing event with ID: {}", id);
        return eventRepository.remove(id);
    }
}
