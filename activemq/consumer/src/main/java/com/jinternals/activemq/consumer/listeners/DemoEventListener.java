package com.jinternals.activemq.consumer.listeners;

import com.jinternals.activemq.consumer.events.DemoEvent;
import com.jinternals.event.bus.consumer.annotations.EventListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class DemoEventListener {

    @EventListener
    public void on(DemoEvent event,@Header("agent-type") String agentType) {
        System.out.println(format("Thread Id : %s , Name : %s " , Thread.currentThread().getId(), Thread.currentThread().getName()));
        System.out.println(format("Received : %s " , event.toString()));
        System.out.println(format("Header -> Agent Type : %s " , agentType));
    }
}
