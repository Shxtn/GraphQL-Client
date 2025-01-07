package edu.fra.uas.model;

import java.time.LocalDateTime;

public class Event {

    // ID des Events
    private String id;

    // Titel des Events
    private String title;

    // Beschreibung des Events
    private String description;

    // Startzeit des Events
    private LocalDateTime startTime;

    // Endzeit des Events
    private LocalDateTime endTime;

    // Standardkonstruktor
    public Event() {
    }

    // Parameterisierter Konstruktor
    public Event(String id, String title, String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter und Setter für ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter und Setter für Titel
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter und Setter für Beschreibung
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter und Setter für Startzeit
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    // Getter und Setter für Endzeit
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // toString-Methode für Debugging und Logging
    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
