package com.springbootproject.toDoList.controller;

import com.springbootproject.toDoList.entity.Task;
import com.springbootproject.toDoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public Task saveTask(@RequestBody Task task){
//        System.out.println("Received Task: " + task);
//        System.out.println("Received Task Name: " + task.getTaskName());
//        System.out.println("Received Task Description: " + task.getTaskDescription());
//        System.out.println("Received Completed: " + task.isCompleted());
        return todoService.saveTask(task);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return todoService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return todoService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task updatedTask){
        return todoService.updateTask(id,updatedTask);
    }


    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id){
        todoService.deleteTaskById(id);
        return "Task with task id " + id + " deleted";
    }

    @DeleteMapping
    public String deleteAllTasks(){
        todoService.deleteAllTasks();
        return "All task deleted";
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable Task.Priority priority) {
        return todoService.getTasksByPriority(priority);
    }

}
