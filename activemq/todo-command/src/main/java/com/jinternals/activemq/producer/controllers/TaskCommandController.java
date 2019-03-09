package com.jinternals.activemq.producer.controllers;

import com.jinternals.activemq.producer.commands.CreateTaskCommand;
import com.jinternals.activemq.producer.entities.Task;
import com.jinternals.activemq.producer.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private CreateTaskCommand createTaskCommand(TaskRequest taskRequest) {
        return new CreateTaskCommand(UUID.randomUUID().toString(),taskRequest.getTitle(),taskRequest.getDescription());
    }
}
