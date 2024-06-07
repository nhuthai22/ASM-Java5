package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;

@RestController
public class AccountAPI {
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountLoginRequest loginRequest) {
        // Thực hiện xác thực đăng nhập
        boolean isAuthenticated = accountService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        try {
            // Thực hiện đăng ký tài khoản
            Account registeredAccount = accountService.register(account);
            if (registeredAccount != null) {
                return ResponseEntity.ok("Tài khoản đã đăng ký thành công");
            } else {
                return ResponseEntity.badRequest().body("Tên người dùng đã tồn tại");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng ký tài khoản không thành công");
        }
    }
    
    // Lớp POJO để chứa dữ liệu đăng nhập
    static class AccountLoginRequest {
        private String username;
        private String password;	
        
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}      
    }

}
