package com.project.todo.springboottodo.app.dtos;

import com.project.todo.springboottodo.app.utils.PriorityEnum;

public class CreateTaskRequestDto {
    private String title;
    private String description;
    private PriorityEnum priority;

    public CreateTaskRequestDto() {
    }

    public CreateTaskRequestDto(String title, String description, PriorityEnum priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }
}
