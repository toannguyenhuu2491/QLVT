package com.qlvt.BTL.service;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AminServiceImpl implements AdminService{
    @Autowired
    private final AdminRepo adminRepo;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    public AminServiceImpl(AdminRepo adminRepo) {
        super();
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin save(AdminRegis regis) {
        Admin admin = new Admin(regis.getTen()
        , regis.getSodienthoai(), regis.getEmail()
        ,regis.getUsername(), pwdEncoder.encode(regis.getPassword()));

        return adminRepo.save(admin);
    }

    @Override
    public Admin getInfo(Admin admin) {
         return adminRepo.findByUsername(admin.getUsername());
    }

    @Override
    public Boolean authenticate(Admin admin) {
        Optional<Admin> optional  = Optional.ofNullable(adminRepo.findByUsername(admin.getUsername()));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(optional.isPresent()){
            Admin authen = optional.get();
            if(bCryptPasswordEncoder.matches(admin.getPassword(), authen.getPassword())){
                return true;
            }

        }

        return false;
    }

    @Override
    public Admin getAdminById(long id) {
        Optional<Admin> optional = adminRepo.findById(id);
        Admin admin = null;
        if(optional.isPresent()){
            admin = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy vật tư");

        }
        return admin;
    }


}
