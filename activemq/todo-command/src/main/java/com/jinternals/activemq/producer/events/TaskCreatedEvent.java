package com.jinternals.activemq.producer.events;


import com.jinternals.event.bus.producer.gateway.annotation.EventRoutingId;

public class TaskCreatedEvent {

    @EventRoutingId
    private String id;
    private String title;
    private String description;

    public TaskCreatedEvent() {
    }

    public TaskCreatedEvent(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
