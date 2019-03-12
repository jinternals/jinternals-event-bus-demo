package com.jinternals.activemq.producer.services;

import com.jinternals.activemq.producer.commands.CreateTaskCommand;
import com.jinternals.activemq.producer.commands.StartTaskCommand;
import com.jinternals.activemq.producer.entities.Task;
import com.jinternals.activemq.producer.events.TaskCreatedEvent;
import com.jinternals.activemq.producer.events.TaskStartedEvent;
import com.jinternals.activemq.producer.repositories.TaskRepository;
import com.jinternals.event.bus.producer.gateway.EventGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class TaskService {

    private TaskRepository taskRepository;
    private EventGateway gateway;

    @Autowired
    public TaskService(TaskRepository taskRepository, EventGateway gateway) {
        this.taskRepository = taskRepository;
        this.gateway = gateway;
    }

    @Transactional
    public Task create(CreateTaskCommand command) {

        Task task = new Task(command.getId(), command.getTitle(), command.getDescription());

        Task save = taskRepository.save(task);

        gateway.publish(new TaskCreatedEvent(command.getId(), command.getTitle(), command.getDescription()));

        return task;

    }

    @Transactional
    public void start(StartTaskCommand command) {

        Optional<Task> optionalTask = taskRepository.findById(command.getId());

        optionalTask.ifPresent(task -> {
                    task.setStarted(true);
                    taskRepository.save(task);
                });

        gateway.publish(new TaskStartedEvent(command.getId()));


    }
}
