package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.service.impl.LoginServiceImpl;
import com.example.demo.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final LoginServiceImpl loginService; // Khai báo biến loginService để tiêm vào đây
    private final JwtUtils jwtUtils; // Khai báo biến jwtUtils để tiêm vào đây
    @Autowired // Tiêm LoginServiceImpl vào đây (tự động tìm kiếm và tiêm)
    public AuthController(LoginServiceImpl loginService, JwtUtils jwtUtils){
        this.loginService = loginService;
        this.jwtUtils = jwtUtils;
    }
    // SignIn
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestParam String username, @RequestParam String password) {
        ResponseData payload = new ResponseData();
        /*
        * Tạo Secret Key của JWT
        * SecretKey secretKey = Jwts.SIG.HS256.key().build(); // Tạo đối tượng SecretKey
        * String secretKeyString = Encoders.BASE64.encode(secretKey.getEncoded()); // Chuyển đổi SecretKey thành String
        * System.out.println(secretKeyString); // In ra màn hình
        */

        if (loginService.checkLogin(username, password)) {
            payload.setDescription("Login successfully");
            payload.setData(jwtUtils.generateToken(username)); // Tạo token từ username
        } else {
            payload.setStatusCode(401);
            payload.setDescription("Username or Password is failed");
            payload.setData(false);
            payload.setSuccess(false);
        }
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    // SignUp
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequest signupRequest) {
        ResponseData payload = new ResponseData();
        if (loginService.checkSignup(signupRequest)) {
            payload.setDescription("Signup successfully");
            payload.setData(true);
        } else {
            payload.setStatusCode(401);
            payload.setDescription("Signup failed");
            payload.setData(false);
        }
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}
