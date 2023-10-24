package com.qlvt.BTL.service;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AminServiceImpl implements AdminService{
    @Autowired
    private AdminRepo adminRepo;

    public AminServiceImpl(AdminRepo adminRepo) {
        super();
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin authenticate(String username, String password) {
        Admin admin = adminRepo.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }

        return null;
    }


    @Override
    public Admin save(AdminRegis regis) {
        Admin admin = new Admin(regis.getTen()
        , regis.getSodienthoai(), regis.getEmail()
        ,regis.getUsername(), regis.getPassword());

        return adminRepo.save(admin);
    }


}
