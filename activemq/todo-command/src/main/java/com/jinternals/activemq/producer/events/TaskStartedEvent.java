package com.jinternals.activemq.producer.events;

import com.jinternals.event.bus.producer.gateway.annotation.EventRoutingId;

public class TaskStartedEvent {
    @EventRoutingId
    private String id;

    public TaskStartedEvent() {
    }

    public TaskStartedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


}
