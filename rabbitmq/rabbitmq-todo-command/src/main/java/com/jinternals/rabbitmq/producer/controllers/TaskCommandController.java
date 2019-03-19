package com.jinternals.rabbitmq.producer.controllers;

import com.jinternals.rabbitmq.producer.commands.CreateTaskCommand;
import com.jinternals.rabbitmq.producer.commands.StartTaskCommand;
import com.jinternals.rabbitmq.producer.entities.Task;
import com.jinternals.rabbitmq.producer.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class TaskCommandController {

    private TaskService taskService;

    @Autowired
    public TaskCommandController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("task")
    public ResponseEntity sendEvent(@RequestBody @Valid TaskRequest taskRequest){
        Task task = taskService.create(createTaskCommand(taskRequest));
        return ok(task);
    }

    @PostMapping("task/{id}/start")
    public void startTask(@PathVariable("id") String id){
        taskService.start(startTaskCommand(id));
    }

    private CreateTaskCommand createTaskCommand(TaskRequest taskRequest) {
        return new CreateTaskCommand(UUID.randomUUID().toString(),taskRequest.getTitle(),taskRequest.getDescription());
    }


    private StartTaskCommand startTaskCommand(String id) {
        return new StartTaskCommand(id);
    }
}
