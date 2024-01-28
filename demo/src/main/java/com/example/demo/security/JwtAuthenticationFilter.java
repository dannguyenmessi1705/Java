package com.example.demo.security;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component // Đánh dấu đây là Bean để đưa vào IOC Container
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils; // Khai báo biến jwtUtils để tiêm vào đây
    private final UserRepository userRepository; // Khai báo biến userRepository để tiêm vào đây
    @Autowired
    public JwtAuthenticationFilter(JwtUtils jwtUtils, UserRepository userRepository){
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }
    @Override
    // Xác thực token và lưu thông tin vào SecurityContext
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String accessToken = getTokenFromHeader(request); // Lấy token từ header
            if (StringUtils.hasText(accessToken) && jwtUtils.verifyToken(accessToken)){ // Nếu token hợp lệ
                String username = jwtUtils.getUserIdFromToken(accessToken); // Lấy id của người dùng từ token
                Users user = userRepository.findByUsername(username); // Tìm kiếm người dùng theo id
                if (user != null){ // Nếu người dùng tồn tại
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, null, new ArrayList<>()); // Tạo đối tượng UsernamePasswordAuthenticationToken
                    SecurityContext securityContext = SecurityContextHolder.getContext(); // Lấy SecurityContext từ SecurityContextHolder để lưu thông tin người dùng
                    securityContext.setAuthentication(usernamePasswordAuthenticationToken); // Xác thực token và lưu thông tin vào SecurityContext
                }
            }
        } catch (Exception e){ // Nếu xác thực token thất bại
            System.out.println("failed on set user authentication"); // In ra màn hình
        }
        filterChain.doFilter(request, response); // Tiếp tục thực hiện các filter tiếp theo
    }
    private String getTokenFromHeader(HttpServletRequest request){ // Hàm lấy token từ header
        String bearerToken = request.getHeader("Authorization"); // Lấy giá trị của header Authorization
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){ // Nếu tồn tại giá trị của header Authorization và bắt đầu bằng Bearer
            return bearerToken.substring(7); // Trả về chuỗi token
        }
        return null; // Trả về null nếu không tồn tại giá trị của header Authorization
    }
}
