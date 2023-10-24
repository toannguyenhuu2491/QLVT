package com.qlvt.BTL.service;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.model.Admin;

public interface AdminService {
    Admin save(AdminRegis regis);

    Admin authenticate(String username, String password);
}
