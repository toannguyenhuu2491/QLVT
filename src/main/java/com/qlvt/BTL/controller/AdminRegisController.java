package com.qlvt.BTL.controller;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class AdminRegisController {
    private AdminService adminService;
    public AdminRegisController(AdminService adminService){
        super();
        this.adminService = adminService;
    }

    @ModelAttribute("admin")
    public AdminRegis adminRegis(){
        return new AdminRegis();
    }
    @GetMapping
    public String showRegisForm(){
        return "registration";
    }

    @PostMapping
    public String regisAdmin(@ModelAttribute("admin")AdminRegis regis){
        adminService.save(regis);
        return "redirect:/registration?success";
    }
}
