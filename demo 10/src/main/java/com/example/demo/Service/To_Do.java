package com.example.demo.Service;
import java.time.LocalDate;

public class To_Do {
    private static long nextId = 1;
    private Long id;

    private String task;
    private String description;
    private boolean completed;
    private LocalDate dueDate;

    public To_Do(Long id, String objective, String description, boolean completed, LocalDate dueDate) {
        this.id = nextId++;
        this.task = objective;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public To_Do() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "To_Do{" +
                ", Task:'" + task + '\'' +
                ", description:'" + description + '\'' +
                ", completed?" + completed +
                ", Due Date:" + dueDate +
                '}';
    }
}
