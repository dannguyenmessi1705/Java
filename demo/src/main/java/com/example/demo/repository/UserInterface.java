package com.example.demo.repository;

import com.example.demo.entity.Users; // Import entity Users.java
import org.springframework.data.jpa.repository.JpaRepository; // Import JpaRepository
import org.springframework.stereotype.Repository;

@Repository("UserInterface") // Đăng ký Bean với tên là UserRepository, Đánh dấu đây là Repository (tương tác
                              // với database) để đưa vào IOC Container
public interface UserInterface extends JpaRepository<Users, Integer> { // Kế thừa JpaRepository với 2 tham số là Entity
                                                                       // và kiểu dữ liệu của khóa chính

}
