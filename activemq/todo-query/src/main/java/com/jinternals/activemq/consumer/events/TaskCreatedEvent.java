package com.jinternals.activemq.consumer.events;


import com.jinternals.event.bus.common.annotations.EventMapper;

@EventMapper("com.jinternals.activemq.producer.events.TaskCreatedEvent")
public class TaskCreatedEvent {

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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


}
