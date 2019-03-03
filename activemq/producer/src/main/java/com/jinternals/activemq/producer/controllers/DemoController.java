package com.jinternals.activemq.producer.controllers;

import com.jinternals.activemq.producer.events.DemoEvent;
import com.jinternals.event.bus.producer.gateway.EventGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Collections;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class DemoController {

    private EventGateway eventGateway;

    @Autowired
    public DemoController(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @RequestMapping("demo/event")
    public ResponseEntity sendEvent(@RequestBody @Valid DemoEvent demoEvent){
        eventGateway.publish(demoEvent, Collections.singletonMap("agent-type","RAW"));
        return ok(demoEvent);
    }
}
