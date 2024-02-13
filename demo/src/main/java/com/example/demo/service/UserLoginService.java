package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.demo.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserLoginService") // Đăng ký Bean với tên là UserLoginService, Đánh dấu đây là Service (xử lý
                             // nghiệp vụ) để đưa vào IOC Container
public class UserLoginService implements LoginServiceImpl {
    private final UserRepository userRepository; // Khai báo biến userRepository để tiêm vào đây
    private final RoleRepository roleRepository; // Khai báo biến roleRepository để tiêm vào đây
    private final PasswordEncoder passwordEncoder; // Khai báo biến passwordEncoder để tiêm vào đây

    // Logger
    private static Logger logger = LoggerFactory.getLogger(UserLoginService.class); // Khai báo biến logger để ghi log (ghi ra màn hình console) và hiển thị thông tin của class đang ghi log

    @Autowired // Tiêm UserRepository vào đây (tự động tìm kiếm và tiêm)
    public UserLoginService(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) { // Khởi tạo đối tượng UserLoginService
        this.userRepository = userRepository; // Gán giá trị cho biến userRepository
        this.roleRepository = roleRepository; // Gán giá trị cho biến roleRepository
        this.passwordEncoder = passwordEncoder; // Gán giá trị cho biến passwordEncoder
    }

    @Override
    public List<UserDTO> getAllUser() {
        logger.trace("Run app"); // Ghi log với mức độ trace 
        logger.debug("Run app"); // Ghi log với mức độ debug (thông tin debug)
        logger.info("Run app"); // Ghi log với mức độ info (thông tin thông thường)
        logger.warn("Run app"); // Ghi log với mức độ warn (cảnh báo)
        logger.error("Run app"); // Ghi log với mức độ error (lỗi)
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
        Users user = userRepository.findByUsername(username); // Tìm kiếm user theo username
        if (user == null)
            return false; // Nếu không tìm thấy user thì trả về false (Không login được)
        return passwordEncoder.matches(password, user.getPassword()); // So sánh password, đúng thì trả về true, ngược
                                                                      // lại trả về false
    } // Kiểm tra login

    @Override
    public Boolean checkSignup(SignupRequest signupRequest) {
        try {
            Users users = userRepository.findByUsername(signupRequest.getUsername()); // Tìm kiếm user theo username
            List<Roles> roles = roleRepository.findById(signupRequest.getRole_id());
            if ((users == null) && (roles.size() == 0)) { // Nếu tìm thấy user thì trả về false (Không signup được)
                return false;
            } else {
                Users user = new Users(); // Khởi tạo đối tượng Users
                Roles role = new Roles(); // Khởi tạo đối tượng Roles
                user.setUsername(signupRequest.getUsername()); // Gán dữ liệu cho các trường
                user.setPassword(passwordEncoder.encode(signupRequest.getPassword())); // Mã hóa mật khẩu trước khi lưu
                                                                                       // vào database
                user.setFullName(signupRequest.getFullName());
                user.setAge(signupRequest.getAge());
                user.setCreatedAt(new Date());
                role.setId(signupRequest.getRole_id());
                user.setRole(role);
                userRepository.save(user); // Lưu vào database
                return true; // Trả về true (signup thành công)
            }
        } catch (Exception e) { // Nếu có lỗi thì trả về false
            return false;
        }
    } // Kiểm tra signup
}
