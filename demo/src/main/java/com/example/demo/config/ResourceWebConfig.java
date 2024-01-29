package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration // Đánh dấu đây là một class cấu hình
public class ResourceWebConfig implements WebMvcConfigurer { // Cấu hình resource cho Spring Boot
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/uploads/","classpath:/templates/"}; // Khai báo đường dẫn tĩnh của các file resource
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){ // Hàm này sẽ cấu hình resource cho Spring Boot
        registry.addResourceHandler("/**") // đường dẫn tới các file resource từ client
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS) // Đường dẫn tĩnh của các file resource
                .setCachePeriod(3600); // Thời gian cache resource là 3600s
    }
}
