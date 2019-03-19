package com.jinternals.rabbitmq.consumer.events;

import com.jinternals.event.bus.common.annotations.EventMapper;

@EventMapper("com.jinternals.rabbitmq.producer.events.TaskStartedEvent")
public class TaskStartedEvent {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskStartedEvent{" +
                "id='" + id + '\'' +
                '}';
    }
}
