package com.example.login.regController;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.domain.Login;
import com.example.login.servreg.RegService;

@Controller
public class RegControl {
    @Autowired
    private RegService rservice;
 
    @GetMapping("/register")
    public String api()
    {
        return "register";
    }
 
    @PostMapping("/reg")
    public String register(@ModelAttribute("user") Login user) {
 
        Login oauthUser = rservice.reg(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }
 
    @GetMapping("/display")
    public String display() {
        return "display";
    }
}
