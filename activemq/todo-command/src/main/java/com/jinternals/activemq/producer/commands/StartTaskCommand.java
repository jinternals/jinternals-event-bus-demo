package com.jinternals.activemq.producer.commands;

public class StartTaskCommand {
    private String id;


    public StartTaskCommand() {
    }

    public StartTaskCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
