package com.example.demo.repository;

import com.example.demo.entity.Users; // Import entity Users.java

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // Import JpaRepository
import org.springframework.stereotype.Repository;

@Repository("UserRepository") // Đăng ký Bean với tên là UserRepository, Đánh dấu đây là Repository (tương tác
                              // với database) để đưa vào IOC Container
public interface UserRepository extends JpaRepository<Users, Integer> { // Kế thừa JpaRepository với 2 tham số là Entity
                                                                       // và kiểu dữ liệu của khóa chính
    // Ngoài các method có sẵn trong JpaRepository, ta có thể khai báo thêm các method
    // Tên method này phải tuân thủ theo quy tắc đặt tên method của Spring Data JPA
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    // Tìm kiếm user theo username và password
    List<Users> findByUsernameAndPassword(String username, String password);
}
