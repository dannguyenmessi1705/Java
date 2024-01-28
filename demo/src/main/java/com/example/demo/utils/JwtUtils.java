package com.example.demo.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component // Đánh dấu đây là Bean để đưa vào IOC Container
public class JwtUtils { // Class JwtUtils
    @Value("${jwt.secretkey}") // Lấy giá trị của thuộc tính jwt.secretkey trong file application.properties
    private String secretKey; // Khai báo biến secretKey = @Value("${jwt.secretkey}")
    // Mã hóa thông tin người dùng thành token
    public String generateToken(String data){ // Hàm generateToken với tham số truyền vào là data
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey)); // Giai mã secretKey
        String JwsToken = Jwts.builder().signWith(secretKey).subject(data).compact(); // Tạo chuỗi token từ secretKey và truyền data vào subject của payload Token JWT
        return JwsToken; // Trả về chuỗi token
    }

    // Giải mã thông tin người dùng từ token
    public String getUserIdFromToken(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey)); // Giai mã secretKey
        Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload(); // Giải mã token và lấy payload của token lưu vào biến claims
        return claims.getSubject().toString(); // Trả về id của người dùng
    }

    // Xác thực Token có hợp lệ hay không
    public boolean verifyToken(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey)); // Giai mã secretKey
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token); // Giải mã token
            return true; // Trả về true nếu token hợp lệ
        } catch (MalformedJwtException e){ // Nếu token không hợp lệ
            System.out.println("Invalid JWT Token");
        } catch (ExpiredJwtException e){ // Nếu token hết hạn
            System.out.println("Expired JWT Token");
        } catch (UnsupportedJwtException e){ // Nếu token không được hỗ trợ
            System.out.println("Unsupported JWT token"); 
        } catch (IllegalArgumentException e){ // Nếu không có thông tin trong token
            System.out.println("JWT claims string is empty");
        }
        return false; // Trả về false nếu token không hợp lệ
    }
}
