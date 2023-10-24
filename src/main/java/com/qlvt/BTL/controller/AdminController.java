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

    private AdminService adminService;

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute(name = "admin")Admin admin, Model model) {
        Admin authen = adminService.authenticate(admin.getUsername(), admin.getPassword());

        if (authen != null) {
            model.addAttribute("admin", authen);
            return "home";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "login";
        }
    }

}
