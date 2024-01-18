package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "users") // Đăng ký đây là 1 entity trong database
public class Users {
    @Id // Khóa chính, nếu trong db có 2 cột là khóa chính thì dùng @IdClass
    // Nếu khóa chính là auto increment thì dùng @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname", length = 50, nullable = false) // Map với cột fullname trong database
    private String fullName; // Tên

    @Column(name = "age", length = 10, nullable = false) // Map với cột age trong database
    private int age;

    @Column(name = "username", length = 50, nullable = false) // Map với cột username trong database
    private String username; // Tên đăng nhập

    @Column(name = "password", length = 500, nullable = false) // Map với cột password trong database
    private String password;

    @Column(name = "created_date", length = 50, nullable = false) // Map với cột created_at trong database
    @Temporal(TemporalType.DATE) // Định dạng kiểu dữ liệu ngày tháng năm trong database là DATE
    private Date createdAt;

    // Không cần thêm cột role_id vì đã có @JoinColumn, nó sẽ tự động thêm cột
    // role_id vào bảng users
    // @Column(name = "role_id") // Map với cột role_id trong database
    // private int roleId;

    // Bảng nào có khóa ngoại thì có @JoinColumn
    @ManyToOne // Kết nối với 1 entity trong database
    @JoinColumn(name = "role_id") // (Chỉ tên cột khóa ngoại) Điều kiện kết nối là cột role_id của entity này phải
    // có giá trị giống với cột role_id tương ứng của entity kia
    private Roles role; // Đây là entity Roles (chỉ trường kết nối). Vì ánh xạ n-1 nên chỉ có 1 role

    // 1-1 với UserDetail
    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn // Khóa chính của UserDetail là user_id, nên ta dùng @PrimaryKeyJoinColumn để
                          // nói với JPA là user_id là khóa chính của UserDetail, cũng là khóa ngoại tham
                          // chiếu tới User
    private UserDetail userDetail;

    // 1-n với Tasks
    @OneToMany(mappedBy = "user")
    private Set<Tasks> tasks;

    public Users() {}

    public Users(int id, String fullName, int age, String username, String password, Date createdAt, Roles role, UserDetail userDetail, Set<Tasks> tasks) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
        this.userDetail = userDetail;
        this.tasks = tasks;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }
}