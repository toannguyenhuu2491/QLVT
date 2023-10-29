package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

//    @GetMapping("/home")
//    public String homePage(Model model){
//
//    }

    @PostMapping("/home")
    public String authenicate(@ModelAttribute("admin")Admin admin, Model model) {
        if (adminService.authenticate(admin)) {
            admin = adminService.getInfo(admin);
            model.addAttribute("admin",admin);
            return "home";
        } else {
            return "login";
        }

    }

}
