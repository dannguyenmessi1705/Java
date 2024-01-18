package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// Projects 1-n Tasks
@Entity(name = "projects")
public class Projects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính tự động tăng
    private int projectId;

    @Column(name = "project_name", length = 100, nullable = false)
    private String projectName;

    @Column(name = "address", length = 1000, nullable = false)
    private String address;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

    // 1-n với Tasks
    @OneToMany(mappedBy = "project") // Kết nối với 1 entity trong database, mappedBy là tên biến Projects trong Tasks.java (chỉ trường kết nối)
    private Set<Tasks> tasks; // Vì ánh xạ 1-n nên có nhiều tasks

    public Projects() {
    }

    public Projects(int projectId, String projectName, String address, Date createdDate, Date start_date, Date end_date, Set<Tasks> tasks) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.address = address;
        this.createdDate = createdDate;
        this.start_date = start_date;
        this.end_date = end_date;
        this.tasks = tasks;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }
}
