package com.example.demo.security;

import com.example.demo.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Đánh dấu đây là class cấu hình
@EnableWebSecurity // Bật tính năng bảo mật trên Web, khi truy cập vào các route sẽ phải đi vào bộ
                   // lọc ở đây
public class CustomFilterSecurity {
    // Đới với User query từ Database
    private final CustomUserDetailsService customUserDetailsService; // Khai báo biến customUserDetailsService để tiêm
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    // vào đây
    @Autowired // Tiêm CustomUserDetailsService vào đây (tự động tìm kiếm và tiêm)
    public CustomFilterSecurity(CustomUserDetailsService customUserDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) { // Khởi tạo đối tượng
        // CustomFilterSecurity
        this.customUserDetailsService = customUserDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    // Quy định các rules
    @Bean // Đánh dấu đây là Bean, ghi đè lên Bean mặc định của Spring Security
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // Cấu hình bộ lọc
        http.cors(cors -> cors.disable()); // Tắt CORS
        http.csrf(csrf -> csrf.disable()); // Tắt CSRF
        http.sessionManagement(session -> session  
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ); // Tắt Session
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**", "/images/**", "/user/getAllUser", "/api-docs**/**", "swagger-ui/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()

        ); // Bắt đầu cấu hình cho phép truy cập các route nào
//      .httpBasic(); // Sử dụng HTTP Basic Authentication (Cơ chế xác thực cơ bản) ở header của
                              // request, nếu dùng JWT thì bỏ đi
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Thêm bộ lọc
                                                                                                    // JwtAuthenticationFilter
                                                                                                    // vào trước
                                                                                                    // UsernamePasswordAuthenticationFilter để xác thực token và lưu thông tin vào SecurityContext trước khi xác thực User
        return http.build(); // Trả về bộ lọc
    }

    // Định nghĩa lại Bean để tạo BcryptPasswordEncoder (Mã hóa mật khẩu)
    @Bean
    public PasswordEncoder passwordEncoder() { // Đánh dấu đây là Bean, ghi đè lên Bean mặc định của Spring Security
        return new BCryptPasswordEncoder(); // Trả về đối tượng BCryptPasswordEncoder
    }

//    // Tạo các User mặc định đưa lên Memory
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() { // Đánh dấu đây là Bean, ghi đè lên Bean mặc định của
//                                                             // Spring Security
//        UserDetails user1 = User.withUsername("USER1") // Tạo đối tượng UserDetails
//                .password(passwordEncoder().encode("123")) // Mã hóa mật khẩu
//                .roles("USER") // Phân quyền
//                .build(); // Tạo đối tượng
//        UserDetails user2 = User.withUsername("USER2") // Tạo đối tượng UserDetails
//                .password(passwordEncoder().encode("456")) // Mã hóa mật khẩu
//                .roles("USER") // Phân quyền
//                .build(); // Tạo đối tượng
//        UserDetails admin = User.withUsername("ADMIN") // Tạo đối tượng UserDetails
//                .password(passwordEncoder().encode("789")) // Mã hóa mật khẩu
//                .roles("ADMIN") // Phân quyền
//                .build(); // Tạo đối tượng
//        return new InMemoryUserDetailsManager(user1, user2, admin); // Trả về đối tượng InMemoryUserDetailsManager
//    }

    @Bean // Đánh dấu đây là Bean, ghi đè lên Bean mặc định của Spring Security
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception { // Định nghĩa lại Bean
                                                                                             // AuthenticationManager để Custom các User từ Database
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class); // Lấy ra đối tượng AuthenticationManagerBuilder từ HttpSecurity để tiêm vào đây
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder()); // Tiêm CustomUserDetailsService và PasswordEncoder vào đây để xác thực User, với PasswordEncoder là để mã hóa mật khẩu trước khi xác thực
        // passwordEncoder(passwordEncoder()) dùng 2 lần vì có 2 đối tượng cần mã hóa mật khẩu là UserDetailsService và AuthenticationManagerBuilder trươc khi xác thực
        return authenticationManagerBuilder.build(); // Trả về đối tượng AuthenticationManager

    }

}
