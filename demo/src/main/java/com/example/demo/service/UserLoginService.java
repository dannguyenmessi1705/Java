package com.example.demo.service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserLoginService") // Đăng ký Bean với tên là UserLoginService, Đánh dấu đây là Service (xử lý
                             // nghiệp vụ) để đưa vào IOC Container
public class UserLoginService implements LoginServiceImpl {

    @Autowired // Tiêm UserRepository vào đây (tự động tìm kiếm và tiêm)
    @Qualifier("UserRepository") // Chỉ định Bean cần tiêm
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> users = userRepository.findAll(); // Lấy tất cả dữ liệu từ bảng users trong database
        List<UserDTO> userDTOs = new ArrayList<>(); // Khởi tạo 1 List rỗng để chứa dữ liệu sau khi chuyển đổi
        for (Users user : users) {
            UserDTO userDTO = new UserDTO(); // Khởi tạo đối tượng UserDTO
            RoleDTO roleDTO = new RoleDTO(); // Khởi tạo đối tượng RoleDTO
            userDTO.setId(user.getId()); // Gán dữ liệu Id của user cho UserDTO
            userDTO.setFullName(user.getFullName()); // Gan dữ liệu FullName của user cho UserDTO
            userDTO.setAge(user.getAge()); // Gan dữ liệu Age của user cho UserDTO
            userDTO.setUsername(user.getUsername()); // Gan dữ liệu Username của user cho UserDTO
            userDTO.setPassword(user.getPassword()); // Gan dữ liệu Password của user cho UserDTO
            userDTO.setCreatedAt(user.getCreatedAt()); // Gan dữ liệu CreatedAt của user cho UserDTO
            roleDTO.setId(user.getRole().getId()); // Gán dữ liệu Id của role cho RoleDTO
            roleDTO.setRoleName(user.getRole().getRoleName()); // Gán dữ liệu RoleName của role cho RoleDTO
            roleDTO.setDesc(user.getRole().getDesc()); // Gán dữ liệu Desc của role cho RoleDTO
            userDTO.setRoleDTO(roleDTO); // Gán dữ liệu RoleDTO cho UserDTO
            userDTOs.add(userDTO); // Thêm vào List
        }
        return userDTOs; // Trả về cho Controller
    } // Lấy dữ liệu từ database và trả về cho Controller

    @Override
    public Boolean checkLogin(String username, String password) {
        List<Users> users = userRepository.findByUsernameAndPassword(username, password);
        return users.size() > 0; // Nếu tìm thấy user thì trả về true, ngược lại trả về false
    } // Kiểm tra login
}
