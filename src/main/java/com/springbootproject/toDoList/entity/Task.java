package com.springbootproject.toDoList.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class Task {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @JsonProperty("taskName")
    private String taskName;

    @JsonProperty("taskDescription")
    private String taskDescription;

    private Boolean completed;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    // Constructors
    public Task() {}

    public Task(Long taskId, String taskName, String taskDescription, Boolean completed, LocalDateTime timestamp) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.completed = completed;
        this.timestamp = timestamp;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", completed=" + completed +
                ", timestamp=" + timestamp +
                '}';
    }
}

