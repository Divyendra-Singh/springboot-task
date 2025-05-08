package com.springbootproject.toDoList.repository;

import com.springbootproject.toDoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Task,Long> {

    public List<Task> findByPriority(Task.Priority priority);
}
