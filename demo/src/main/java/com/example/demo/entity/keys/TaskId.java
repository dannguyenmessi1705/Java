package com.example.demo.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable // Đây là khóa chính phụ của Task
public class TaskId implements Serializable {
    @Column(name = "user_id") // Khóa chính phụ của Task
    private int userId; // Khóa chính phụ của Task

    @Column(name = "project_id") // Khóa chính phụ của Task
    private int projectId; // Khóa chính phụ của Task

    public TaskId() {
    }

    public TaskId(int userId, int projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
