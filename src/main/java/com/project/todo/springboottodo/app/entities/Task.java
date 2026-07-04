package com.project.todo.springboottodo.app.entities;

import com.project.todo.springboottodo.app.utils.PriorityEnum;
import com.project.todo.springboottodo.app.utils.StateEnum;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private Long id_task;
    private String title;
    private String description;
    private PriorityEnum priority;
    private StateEnum state;
    private LocalDate date;

    public Task() {
    }

    public Task(Long id_task, String title, String description, PriorityEnum priority, StateEnum state, LocalDate date) {
        this.id_task = id_task;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
        this.date = date;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
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

    public StateEnum getState() {
        return state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id_task, task.id_task) && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_task, title);
    }
}
