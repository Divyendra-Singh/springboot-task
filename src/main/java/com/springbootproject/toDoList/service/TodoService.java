package com.springbootproject.toDoList.service;

import com.springbootproject.toDoList.entity.Task;
import java.util.List;
import java.util.Optional;

public interface TodoService {

    Task saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Task updateTask(Long id, Task updatedTask);

    void deleteTaskById(Long id);

    void deleteAllTasks();

    List<Task> getTasksByPriority(Task.Priority priority);
}
