package com.jinternals.rabbitmq.consumer.listeners;

import com.jinternals.rabbitmq.consumer.entities.Task;
import com.jinternals.rabbitmq.consumer.events.TaskCreatedEvent;
import com.jinternals.rabbitmq.consumer.repositories.TaskRepository;
import com.jinternals.event.bus.consumer.annotations.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class TaskCreatedEventListener {

    @Autowired
    public TaskRepository taskRepository;

    @EventListener
    public void on(TaskCreatedEvent event) {

        System.out.println(format("Thread Id : %s , Name : %s " , Thread.currentThread().getId(), Thread.currentThread().getName()));
        System.out.println(format("Received : %s " , event.toString()));
        taskRepository.save(new Task(event.getId(),event.getTitle(),event.getDescription()));

    }
}
