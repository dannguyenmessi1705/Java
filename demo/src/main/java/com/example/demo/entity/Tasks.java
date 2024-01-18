package com.example.demo.entity;

import com.example.demo.entity.keys.TaskId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Tasks là bảng trung gian giữa projects n-n với users
// tasks n-1 projects, task n-1 users
@Entity(name = "tasks")
public class Tasks {
    // Vì 2 thuộc tính user_id và project_id của tasks hợp với nhau thành khóa chính, tuy nhiên mỗi 1 khóa lại làm khóa ngoại
    // nên ta dùng @Embeddable để sau khi khai báo tham chiếu, cột trùng tên sẽ không tạo lại
    // Trước tiên tạo package keys chứa các class khóa
    // Sau đó tạo class TaskId trong package keys với @Embeddable
    // Trong class TaskId khai báo các thuộc tính user_id và project_id
    // Trong class Tasks khai báo @EmbeddedId và khởi tạo đối tượng TaskId
    @EmbeddedId
    private TaskId taskId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false) // Không cho phép insert và update cột user_id vì nó đã được khai báo trong TaskId
    private Users user;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false) // Không cho phép insert và update cột project_id vì nó đã được khai báo trong TaskId
    private Projects project;

    public Tasks() {
    }

    public Tasks(TaskId taskId, Users user, Projects project) {
        this.taskId = taskId;
        this.user = user;
        this.project = project;
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskId taskId) {
        this.taskId = taskId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }
}
