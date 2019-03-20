package com.jinternals.rabbitmq.producer.events;


import com.jinternals.event.bus.common.annotations.EventId;

import javax.validation.constraints.NotNull;

public class TaskCreatedEvent {

    @EventId
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