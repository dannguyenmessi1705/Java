package com.example.demo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component // Đánh dấu đây là Bean để đưa vào IOC Container
public class JwtUtils { // Class JwtUtils
    @Value("${jwt.secretkey}") // Lấy giá trị của thuộc tính jwt.secretkey trong file application.properties
    private String secretKey; // Khai báo biến secretKey = @Value("${jwt.secretkey}")
    public String generateToken(String data){ // Hàm generateToken với tham số truyền vào là data
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey)); // Giai mã secretKey
        String JwsToken = Jwts.builder().signWith(secretKey).content(data).compact(); // Tạo chuỗi token từ secretKey và data
        return JwsToken; // Trả về chuỗi token
    }
}
