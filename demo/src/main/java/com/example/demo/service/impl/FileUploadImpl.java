package com.example.demo.service.impl;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadImpl {
    boolean validateFiles(MultipartFile files) throws Exception; // Hàm này sẽ kiểm tra xem file có hợp lệ không
    boolean isSupportedExtension(String extension); // Hàm này sẽ kiểm tra xem file có đúng định dạng không (.png, .jpg, .jpeg, ...)
    boolean isSupportedContentType(String contentType); // Hàm này sẽ kiểm tra xem file có đúng định dạng không (image/png, image/jpg, image/jpeg, ...)
    String storeFile(MultipartFile file) throws Exception; // Hàm này sẽ lưu file lên server
}
