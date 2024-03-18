package com.example.demo.Service;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ToDoService {
    void addTask(String task, String description, boolean completed, LocalDate dueDate);
    ArrayList<To_Do> displayTasks();
    void removeTask(Long id);
    To_Do updateTask(Long id, To_Do updatedToDo);
    To_Do getTaskById(long id);
    void removeAllTasks();


}
