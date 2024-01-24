package com.example.demo.repository;

import com.example.demo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    // Ngoài các method có sẵn trong JpaRepository, ta có thể khai báo thêm các
    // method
    // Tên method này phải tuân thủ theo quy tắc đặt tên method của Spring Data JPA
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    // Tìm kiếm Role theo Id
    List<Roles> findById(int id);
}
