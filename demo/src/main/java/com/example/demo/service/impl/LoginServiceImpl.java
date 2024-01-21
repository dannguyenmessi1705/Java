package com.example.demo.service.impl;


import com.example.demo.dto.UserDTO;

import java.util.List;

// dùng để định nghĩa các method xử lý logic
public interface LoginServiceImpl {
    // Lấy ra tất cả các user
    List<UserDTO> getAllUser();

    // Kiểm tra user có tồn tại hay không
    Boolean checkLogin(String username, String password);
    
}
