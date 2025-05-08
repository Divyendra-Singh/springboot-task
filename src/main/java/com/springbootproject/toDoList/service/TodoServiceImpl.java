package com.springbootproject.toDoList.service;

import com.springbootproject.toDoList.entity.Task;
import com.springbootproject.toDoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Task saveTask(Task task) {
        return todoRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        if(todoRepository.existsById(id)){
            updatedTask.setTaskId(id);
            return todoRepository.save(updatedTask);
        }
        else return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void deleteAllTasks() {
        todoRepository.deleteAll();
    }

    @Override
    public List<Task> getTasksByPriority(Task.Priority priority) {
        return todoRepository.findByPriority(priority);
    }


}
