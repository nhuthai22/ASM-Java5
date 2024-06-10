package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/Login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/submitLogin")
    public String postLogin() {
        return "index";
    }

    @GetMapping("/Register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/submitRegister")
    public String postRegister() {
        return "redirect:/Login";
    }

    @GetMapping("/Cart")
    public String getCart(){
        return "/Cart";
    }

    @GetMapping("/detail")
    public String getdetail(){
        return "/trasua";
    }
    
    @GetMapping("/gioithieu")
    public String getGioithieu(){
        return "/gioithieu";
    }
    
    @GetMapping("/detail2")
    public String getdetail2(){
        return "/banhngot";
    }
    
    @GetMapping("/ctspTraSua/{id}")
    public String getCtspTra(){
        return "/ctspTraSua2"; 
    }
    
    @GetMapping("/ctspBanh/{id}")
    public String getCtspBanh(){
        return "/ctspBanh2"; 
    }
}
