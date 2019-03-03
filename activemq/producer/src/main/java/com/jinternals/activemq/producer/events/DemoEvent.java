package com.jinternals.activemq.producer.events;


import com.jinternals.event.bus.common.annotations.EventId;

import javax.validation.constraints.NotNull;

public class DemoEvent {

    @NotNull
    @EventId
    private String id;
    @NotNull
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
