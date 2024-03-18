package com.example.demo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
@org.springframework.stereotype.Service


public class Service implements ToDoService {
    private Long nextId = 1L;
    ArrayList<To_Do> taskList = new ArrayList<>();

    @Override
    public void addTask(String task, String description, boolean completed, LocalDate dueDate) {
        To_Do objective = new To_Do(nextId++, task, description, completed, dueDate);
        taskList.add(objective);


    }

    @Override
    public ArrayList<To_Do> displayTasks() {

        return taskList;
    }

    @Override
    public void removeTask(Long id) {
        taskList.removeIf(task -> task.getId() == id);

    }

    @Override
    public To_Do updateTask(Long id, To_Do updatedToDo) {
        for (int i = 0; i < taskList.size(); i++) {
            To_Do task = taskList.get(i);
            if (task.getId().equals(id)) {
                task.setTask(updatedToDo.getTask());
                task.setDescription(updatedToDo.getDescription());
                task.setCompleted(updatedToDo.isCompleted());
                task.setDueDate(updatedToDo.getDueDate());
                return task;
            }
        }


        throw new ToDoItemNotFoundException("Task with ID " + id + " not found");
    }

    @Override
    public To_Do getTaskById(long id) {
        for (int i = 0; i < taskList.size(); i++) {
            To_Do task = taskList.get(i);
            if (task.getId().equals(id)) {
                        return task;
            }
        }
        throw new ToDoItemNotFoundException("Task with ID " + id + " not found");
    }

    public class ToDoItemNotFoundException extends RuntimeException {
        public ToDoItemNotFoundException(String message) {
            super(message);
        }
    }
    @Override
    public void removeAllTasks() {
        taskList.clear();
    }
}
