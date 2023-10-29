package com.qlvt.BTL.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ten;
    private String username;
    private String password;
    private String sodienthoai;
    private String email;

    public Admin() {
    }

    public Admin(String ten, String sodienthoai, String email, String username, String password) {
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
