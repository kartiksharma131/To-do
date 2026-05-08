package com.todoapp.crud.todoapp.models;

import org.springframework.stereotype.Component;

@Component
public class ToDo {
    private int id;
    private  String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;
}
