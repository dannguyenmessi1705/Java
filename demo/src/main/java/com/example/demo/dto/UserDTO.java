package com.example.demo.dto;
// Đây là DTO (Data Transfer Object) dùng để trả về dữ liệu dạng JSON cho client (đối tượng này sẽ được trả về khi client gọi API)

// và dữ liệu bao gồm các trường được liệt kê ở dưới

import java.util.Date;
import com.example.demo.dto.RoleDTO;

public class UserDTO {
    private int id;
    private String fullName; // Tên
    private int age;
    private String username; // Tên đăng nhập
    private String password;
    private Date createdAt;
    private RoleDTO role;

    public RoleDTO getRole() {
        return role;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.role = roleDTO;
    }

    public UserDTO() {
    }

    public UserDTO(int id, String fullName, int age, String username, String password, Date createdAt, RoleDTO role) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
