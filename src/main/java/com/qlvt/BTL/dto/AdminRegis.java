package com.qlvt.BTL.dto;

public class AdminRegis {
    private String ten;
    private String sodienthoai;
    private String email;
    private String username;
    private String password;



    public AdminRegis(String ten,  String sodienthoai, String email, String username, String password) {
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AdminRegis() {

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
