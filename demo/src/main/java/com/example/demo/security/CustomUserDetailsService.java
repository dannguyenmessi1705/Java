package com.example.demo.security;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service // Đánh dấu đây là Service (xử lý nghiệp vụ) để đưa vào IOC Container
public class CustomUserDetailsService implements UserDetailsService { // Kế thừa interface UserDetailsService
    private final UserRepository userRepository; // Khai báo biến userRepository để tiêm vào đây

    @Autowired // Tiêm UserRepository vào đây (tự động tìm kiếm và tiêm)
    public CustomUserDetailsService(UserRepository userRepository) { // Khởi tạo đối tượng CustomUserDetailsService
        this.userRepository = userRepository; // Gán giá trị cho biến userRepository
    }

    @Override // Ghi đè phương thức loadUserByUsername
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Tham số truyền vào là
                                                                                              // username
        Users users = userRepository.findByUsername(username); // Tìm kiếm user theo username
        if (users == null) { // Nếu không tìm thấy
            throw new UsernameNotFoundException("User isn't existed"); // Ném ra ngoại lệ UsernameNotFoundException
        }
        return new User(username, users.getPassword(), new ArrayList<>()); // Trả về đối tượng User với username,
                                                                           // password và danh sách các quyền
    }
}
