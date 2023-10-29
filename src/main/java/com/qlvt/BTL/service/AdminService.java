package com.qlvt.BTL.service;

import com.qlvt.BTL.dto.AdminRegis;
import com.qlvt.BTL.model.Admin;

public interface AdminService {
    Admin save(AdminRegis regis);
    Admin getInfo(Admin admin);
    Boolean authenticate(Admin admin);

    Admin getAdminById(long id);
}
