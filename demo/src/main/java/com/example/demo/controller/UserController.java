package com.example.demo.controller;
/*
 * api/user
 * RestController: trả về dữ liệu dạng JSON
 * Controller: trả về dữ liệu dạng HTML
 * ResponseBody: trả về dữ liệu dạng JSON, kết hợp với Controller để trả về dữ liệu dạng HTML và JSON
 * RequestBody: nhận dữ liệu dạng JSON
 * RequestHeader: nhận dữ liệu dạng header
 * RequestMapping: nhận dữ liệu dạng GET, POST, PUT, DELETE, PATCH
 * RequestParam: nhận dữ liệu dạng query string
 * PathVariable: nhận dữ liệu dạng path, ví dụ: /user/{id}, id là đường dẫn động (dynamic path)
 * GetMapping: nhận dữ liệu dạng GET
 * PostMapping: nhận dữ liệu dạng POST
 * PutMapping: nhận dữ liệu dạng PUT
 * DeleteMapping: nhận dữ liệu dạng DELETE
 * PatchMapping: nhận dữ liệu dạng PATCH
 * */

import com.example.demo.payload.Payload;
import com.example.demo.service.impl.LoginServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode; // Để trả về mã lỗi HTTP
import org.springframework.http.HttpStatus; // Để trả về mã lỗi HTTP
import org.springframework.http.ResponseEntity; // Để trả về dữ liệu dạng JSON, kết hợp với HttpStatus để trả về mã lỗi HTTP
import com.example.demo.model.User;
import com.example.demo.service.UserLoginService;

import java.util.List;

@RestController // Đăng ký Controller này là RestController
@RequestMapping("/user") // Đăng ký đường dẫn cho Controller này
public class UserController {
    // Query từ database
    @Autowired // Tiêm UserLoginService vào đây (tự động tìm kiếm và tiêm)
    LoginServiceImpl loginServiceImpl; // Khởi tạo đối tượng UserLoginService

    @GetMapping("/getAllUser") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là /getAllUser
    // (đường dẫn cuối cùng là /user/getAllUser)
    public ResponseEntity<?> getAllUser() {
        Payload payload = new Payload();
        payload.setData(loginServiceImpl.getAllUser());
        return new ResponseEntity<>(payload, HttpStatus.OK); // Trả về dữ liệu dạng JSON
    }

    // SignIn
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestParam String username, @RequestParam String password){
        Payload payload = new Payload();
        if (loginServiceImpl.checkLogin(username, password)){
            payload.setDescription("Login successfully");
            payload.setData(true);
        }
        else {
            payload.setStatusCode(401);
            payload.setDescription("Username or Password is failed");
            payload.setData(false);
        }
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    @GetMapping("/add") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là /add (đường dẫn
    // cuối cùng là /user/add)
    public String add() {
        return "addUser";
    }

    @GetMapping("getDetail/{username}/{id}") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là
    // /getDetail/{username}/{id} (đường dẫn cuối cùng là
    // /user/getDetail/{username}/{id})
    public String getDetail(@PathVariable("username") String username, @PathVariable("id") int id) {
        return "Get Detail " + username + " " + id + "";
    } // Lấy dữ liệu từ đường dẫn động (dynamic path), ví dụ: /user/getDetail/didan/1

    @GetMapping("/addUser") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là
    // /add/{username}/{id} (đường dẫn cuối cùng là /user/add/{username}/{id})
    public String addUser(@RequestParam("username") String username, @RequestParam("id") int id) {
        return "Add User " + username + " " + id + "";
    } // Lấy dữ liệu từ query string, ví dụ: /user/add?username=didan&id=1

    @PostMapping("/create") // Đăng ký đường dẫn cho phương thức này là POST, truyền vào là 1 đối tượng dạng
    // JSON
    public String createUser(@RequestBody User user) {
        return "Creare one man " + user.getId() + " " + user.getName() + " " + user.getAge();
    } // Phương thức này cho phép truyền các đối tượng của USER dạng JSON vào

    @PostMapping("/createMulti") // Đăng ký đường dẫn cho phương thức này là POST, truyền vào là 1 đối tượng dạng
    // JSON
    public String createMulti(@RequestBody List<User> user) {
        for (User it : user) {
            System.out.println("man + " + it.getId() + " " + it.getName() + " " + it.getAge());
        }
        return "";
    } // Phương thức này cho phép truyền các đối tượng của USER dạng JSON vào

    // Trả về dữ liệu dạng JSON, kết hợp với HttpStatus để trả về mã lỗi HTTP
    @GetMapping("/getOne") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là /getOne (đường
    // dẫn
    // cuối cùng là /user/getOne)
    public ResponseEntity<?> getOne() {
        User user = new User();
        user.setId(1);
        user.setName("didan");
        user.setAge(20);
        return new ResponseEntity<>(user, HttpStatus.OK); // Thông báo thành công và trả về dữ liệu dạng
        // JSON
    }

    // Trả về dữ liệu dạng JSON, kết hợp với HttpStatus để trả về mã lỗi HTTP, đối
    // với web 404
    @GetMapping("/getOne404") // Đăng ký đường dẫn cho phương thức này là GET, có endpoint là /getOne404
    // (đường dẫn cuối cùng là /user/getOne404)
    public ResponseEntity<String> getOne404() {
        String errmsg = "Not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errmsg); // Thông báo lỗi và trả về dữ liệu dạng JSON
    }
}
