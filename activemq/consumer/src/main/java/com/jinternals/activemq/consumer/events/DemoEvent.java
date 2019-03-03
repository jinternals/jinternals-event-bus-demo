package com.jinternals.activemq.consumer.events;


import com.jinternals.event.bus.common.annotations.EventMapper;

import javax.validation.constraints.NotNull;

@EventMapper("com.jinternals.activemq.producer.events.DemoEvent")
public class DemoEvent {

    @NotNull
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
