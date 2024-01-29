package com.example.demo.service;

import com.example.demo.service.impl.FileUploadImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tika.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class FileUploadService implements FileUploadImpl {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private Path rootPath;
    public void init(){
        this.rootPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.rootPath);
        }catch (Exception e){
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    @Override
    public boolean validateFiles(MultipartFile file) throws Exception {
        if (file.getSize() > 10000000){
            System.out.println("File size should be less than 10MB");
            return false;
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(!isSupportedExtension(extension)){
            System.out.println("File extension is not support");
            return false;
        }
        Tika tika = new Tika();
        String mimeType = tika.detect(file.getInputStream());
        if(!isSupportedContentType(mimeType)){
            System.out.println("Content Type is not support");
            return false;
        }
        return true;
    }

    @Override
    public boolean isSupportedExtension(String extension) {
        return extension != null &&
                extension.equals("png")
                || extension.equals("jpg")
                || extension.equals("jpeg");
    }

    @Override
    public boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }

    @Override
    public String storeFile(MultipartFile file) throws Exception {
        init();
        String fileName = new Date().getTime() + "-file." + FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            if(validateFiles(file)){
                if (fileName.contains("..")) {
                    throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                Path targetLocation = this.rootPath.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            } else throw new Exception("Could not upload file");
            return fileName;
        } catch (IOException e){
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
}
