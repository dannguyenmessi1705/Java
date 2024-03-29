package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean // Đưa lên Bean để sử dụng ở các class khác
    public JedisConnectionFactory connectRedis(){ // Kết nối đến Redis
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(); // Cấu hình kết nối
//        config.setDatabase(1); // Chọn database
        config.setHostName("redis-12204.c302.asia-northeast1-1.gce.cloud.redislabs.com"); // Địa chỉ host
//        config.setUsername("default"); // Tên đăng nhập
        config.setPassword("LaBDA4NGWeKLKISxlH2IernqYFWfwKTG"); // Mật khẩu
        config.setPort(12204); // Cổng kết nối
        return new JedisConnectionFactory(config); // Trả về kết nối
    }

    @Bean // Đưa lên Bean để sử dụng ở các class khác
    RedisTemplate<String, Object> redisTemplate(){ // Template để thao tác với Redis (thêm, sửa, xóa, lấy dữ liệu) với key kiểu String và value kiểu Object
        RedisTemplate<String, Object> template = new RedisTemplate<>(); // Khởi tạo template, 
        template.setConnectionFactory(connectRedis()); // Kết nối đến Redis thông qua connectRedis ở trên
        // template.setKeySerializer(new StringRedisSerializer()); // Set kiểu dữ liệu cho key là String
        // template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // Set kiểu dữ liệu cho value là JSON
        return template; // Trả về template để sử dụng
    }
}
