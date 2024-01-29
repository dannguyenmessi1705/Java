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

@Service // Đánh dấu đây là một service đưa vào Spring Container
public class FileUploadService implements FileUploadImpl {
    @Value("${file.upload-dir}") // Lấy giá trị của biến file.upload-dir trong file application.properties và gán vào biến uploadDir
    private String uploadDir; 
    private Path rootPath; // Tạo một biến rootPath để lưu đường dẫn đến thư mục lưu file trên server
    public void init(){ // Hàm này sẽ khởi tạo thư mục lưu file trên server
        this.rootPath = Paths.get(uploadDir).toAbsolutePath().normalize(); // Lấy đường dẫn tuyệt đối của thư mục lưu file trên server
        try{
            Files.createDirectories(this.rootPath); // Tạo thư mục lưu file trên server nếu chưa tồn tại
        }catch (Exception e){
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", e); // Nếu không tạo được thư mục lưu file trên server thì sẽ báo lỗi
        }
    }

    @Override
    public boolean validateFiles(MultipartFile file) throws Exception { // Hàm này sẽ kiểm tra xem file có hợp lệ không
        if (file.getSize() > 10000000){ // Nếu kích thước file lớn hơn 10MB thì sẽ báo lỗi
            System.out.println("File size should be less than 10MB"); 
            return false;
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // Lấy đuôi file
        if(!isSupportedExtension(extension)){ // Kiểm tra xem đuôi file có hợp lệ không
            System.out.println("File extension is not support"); // Nếu không hợp lệ thì sẽ báo lỗi
            return false;
        }
        Tika tika = new Tika(); // Tạo một đối tượng Tika để kiểm tra định dạng file
        String mimeType = tika.detect(file.getInputStream()); // Lấy định dạng file
        if(!isSupportedContentType(mimeType)){ // Kiểm tra xem định dạng file có hợp lệ không
            System.out.println("Content Type is not support"); // Nếu không hợp lệ thì sẽ báo lỗi
            return false; 
        }
        return true;
    }

    @Override
    public boolean isSupportedExtension(String extension) { // Hàm này sẽ kiểm tra xem đuôi file có hợp lệ không
        return extension != null && 
                extension.equals("png")
                || extension.equals("jpg")
                || extension.equals("jpeg"); // Nếu đuôi file là .png, .jpg, .jpeg thì sẽ trả về true
    }

    @Override
    public boolean isSupportedContentType(String contentType) { // Hàm này sẽ kiểm tra xem định dạng file có hợp lệ không
        return contentType.equals("image/png") 
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg"); // Nếu định dạng file là image/png, image/jpg, image/jpeg thì sẽ trả về true
    }

    @Override
    public String storeFile(MultipartFile file) throws Exception { // Hàm này sẽ lưu file lên server
        init(); // Khởi tạo thư mục lưu file trên server
        String fileName = new Date().getTime() + "-file." + FilenameUtils.getExtension(file.getOriginalFilename()); // Tạo tên file mới
        try {
            if(validateFiles(file)){ // Kiểm tra xem file có hợp lệ không
                if (fileName.contains("..")) { // Kiểm tra xem tên file có chứa các kí tự đặc biệt không
                    throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName); // Nếu có thì sẽ báo lỗi
                }
                Path targetLocation = this.rootPath.resolve(fileName); // Dùng đường dẫn tuyệt đối của thư mục lưu file trên server để lưu file
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING); // Lưu file nếu file đã tồn tại thì sẽ ghi đè lên file cũ
            } else throw new Exception("Could not upload file"); // Nếu file không hợp lệ thì sẽ báo lỗi
            return fileName; // Trả về tên file
        } catch (IOException e){
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", e); // Nếu không lưu được file thì sẽ báo lỗi
        }
    }
}
