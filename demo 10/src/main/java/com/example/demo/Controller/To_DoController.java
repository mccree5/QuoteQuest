package com.example.demo.Controller;
import com.example.demo.Service.ToDoService;
import com.example.demo.Service.To_Do;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/to-do-list")
public class To_DoController {
    private final ToDoService toDoService;

    @Autowired
    public To_DoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

   @GetMapping("/{id}")
   public To_Do getTaskById(@PathVariable Long id) {
       return toDoService.getTaskById(id);
   }
   @DeleteMapping("/{id}")
   public void removeTask(@PathVariable Long id) {
       toDoService.removeTask(id);
   }
   @PutMapping("/{id}")
    public To_Do updateTask(@PathVariable Long id,@RequestBody To_Do updatedToDo ){
       return toDoService.updateTask(id,updatedToDo);
   }
   @PostMapping("/addTask")
    public void addTask(@RequestBody To_Do toDo){
       toDoService.addTask(toDo.getTask(), toDo.getDescription(), toDo.isCompleted(), toDo.getDueDate());
   }
   @GetMapping("/allTasks")
       public ArrayList <To_Do> displayTasks(){
           return toDoService.displayTasks();
       }
       @DeleteMapping("/clearTasks")
       public void removeAllTasks(){
        toDoService.removeAllTasks();
       }
}
