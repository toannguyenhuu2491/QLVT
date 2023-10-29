package com.qlvt.BTL.service;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AminServiceImpl implements AdminService{
    @Autowired
    private AdminRepo adminRepo;

    public AminServiceImpl(AdminRepo adminRepo) {
        super();
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin save(AdminRegis regis) {
        Admin admin = new Admin(regis.getTen()
        , regis.getSodienthoai(), regis.getEmail()
        ,regis.getUsername(), regis.getPassword());

        return adminRepo.save(admin);
    }

    @Override
    public Admin getInfo(Admin admin) {
         return adminRepo.findByUsername(admin.getUsername());
    }

    @Override
    public Boolean authenticate(Admin admin) {
        Admin authen = adminRepo.findByUsername(admin.getUsername());
        return authen != null && authen.getPassword().equals(admin.getPassword());

    }


}
