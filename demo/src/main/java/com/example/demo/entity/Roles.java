package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column; // Import thư viện để đăng ký đây là 1 cột trong database
import jakarta.persistence.Entity; // Import thư viện để đăng ký đây là 1 entity trong database
import jakarta.persistence.GeneratedValue; // Thư viện để đăng ký kiểu dữ liệu auto increment
import jakarta.persistence.GenerationType; // Thư viện để đăng ký kiểu dữ liệu auto increment
import jakarta.persistence.Id; // Import thư viện để đăng ký đây là 1 id trong database
import jakarta.persistence.OneToMany; // Import thư viện để kết nối với 1 entity trong database

@Entity(name = "roles") // Đăng ký đây là 1 entity trong database
public class Roles {
    @Id // Khóa chính, nếu trong db có 2 cột là khóa chính thì dùng @IdClass
    // Nếu khóa chính là auto increment thì dùng @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tăng tự động theo kiểu số nguyên
    private int id;

    @Column(name = "role_name", length = 50, nullable = false) // Map với cột role_name trong database
    private String roleName;

    @Column(name = "description", length = 500) // Map với cột description trong database
    private String desc;


    // Bảng nào không có khóa ngoại thì có mappedBy
    @OneToMany(mappedBy = "role") // Kết nối với 1 entity trong database, mappedBy là tên biến Roles trong
    // Users.java (chỉ trường kết nối)
    private Set<Users> users; // Vì ánh xạ 1-n nên có nhiều users


    public Roles() {
    }

    public Roles(int id, String roleName, String desc, Set<Users> users) {
        this.id = id;
        this.roleName = roleName;
        this.desc = desc;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }


}
