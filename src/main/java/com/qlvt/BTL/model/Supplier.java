package com.qlvt.BTL.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ten;
    private String sodienthoai;
    private String diachi;
    private String email;
    private String mota;

    @OneToMany(mappedBy = "supplier", cascade= CascadeType.ALL)
    private List<Item> item = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(String ten, String sodienthoai, String diachi, String email, String mota) {
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.email = email;
        this.mota = mota;
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

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
