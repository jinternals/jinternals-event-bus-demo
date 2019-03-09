package com.jinternals.activemq.consumer.listeners;

import com.jinternals.activemq.consumer.events.TaskCreatedEvent;
import com.jinternals.event.bus.consumer.annotations.EventListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class TaskCreatedEventListener {

    @EventListener
    public void on(TaskCreatedEvent event) {
        System.out.println(format("Thread Id : %s , Name : %s " , Thread.currentThread().getId(), Thread.currentThread().getName()));
        System.out.println(format("Received : %s " , event.toString()));
    }
}
