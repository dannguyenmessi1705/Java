package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.service.impl.FileUploadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    private final FileUploadImpl fileUpload;
    @Autowired
    public FileController(FileUploadImpl fileUpload){
        this.fileUpload = fileUpload;
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile( // Hàm này sẽ upload file lên server
            @RequestParam(name = "file", required = false) MultipartFile file, // Tham số file sẽ được gửi từ client lên server
            @RequestParam("fullName") String fullName, // Tham số fullName sẽ được gửi từ client lên server
            @RequestParam("age") int age // Tham số age sẽ được gửi từ client lên server
    ){
        ResponseData payload = new ResponseData();
        Map<String, String> res = new HashMap<>();
        try{
            String fileName = fileUpload.storeFile(file); // Lưu file lên server
            payload.setDescription("Upload File Successful");
            res.put("fileName", fileName);
            res.put("fullName", fullName);
            res.put("age", String.valueOf(age));
            payload.setData(res);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }catch (Exception e){
            payload.setStatusCode(500);
            payload.setSuccess(false);
            payload.setDescription("Failed to Upload Image");
            return new ResponseEntity<>(payload, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
