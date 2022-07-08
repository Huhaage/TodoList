package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.fms.entities.Users;
import fr.fms.job.IBusinessImpl;

@Controller
public class UsersController {
    @Autowired
    IBusinessImpl iBusinessImpl;
    
    @GetMapping("/login")
    public String login(Model model, Users user) {
        return "login";
    }
    
    @PostMapping("/login")
    public String connect() {
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
    
    @PostMapping("/logout")
    public String disconnect() {
        return "redirect:/login";
    }
}
