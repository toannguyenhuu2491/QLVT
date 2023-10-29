package com.qlvt.BTL.repository;

import com.qlvt.BTL.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
