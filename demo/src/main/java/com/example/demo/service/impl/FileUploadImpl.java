package com.example.demo.service.impl;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadImpl {
    boolean validateFiles(MultipartFile files) throws Exception;
    boolean isSupportedExtension(String extension);
    boolean isSupportedContentType(String contentType);
    String storeFile(MultipartFile file) throws Exception;
}
