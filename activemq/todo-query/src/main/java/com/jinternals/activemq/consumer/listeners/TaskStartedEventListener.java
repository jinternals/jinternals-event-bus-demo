package com.jinternals.activemq.consumer.listeners;

import com.jinternals.activemq.consumer.entities.Task;
import com.jinternals.activemq.consumer.events.TaskCreatedEvent;
import com.jinternals.activemq.consumer.events.TaskStartedEvent;
import com.jinternals.activemq.consumer.repositories.TaskRepository;
import com.jinternals.event.bus.consumer.annotations.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class TaskStartedEventListener {

    @Autowired
    public TaskRepository taskRepository;

    @EventListener
    public void on(TaskStartedEvent event) {

        System.out.println(format("Thread Id : %s , Name : %s " , Thread.currentThread().getId(), Thread.currentThread().getName()));
        System.out.println(format("Received : %s " , event.toString()));

        taskRepository.findById(event.getId()).ifPresent(task -> {
            task.setStarted(true);
            taskRepository.save(task);
        });
    }
}
