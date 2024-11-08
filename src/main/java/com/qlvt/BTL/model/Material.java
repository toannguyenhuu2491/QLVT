package com.qlvt.BTL.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ten;
    private String loai;
    private long soluong;
    private String donvi;
    private long dongia;

    private String mota;
    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<Item> item = new ArrayList<>();


    public Material() {
    }

    public Material(String ten, String loai, long soluong, String donvi, long dongia, String mota) {
        this.ten = ten;
        this.loai = loai;
        this.soluong = soluong;
        this.donvi = donvi;
        this.dongia = dongia;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public long getSoluong() {
        return soluong;
    }

    public void setSoluong(long soluong) {
        this.soluong = soluong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public long getDongia() {
        return dongia;
    }

    public void setDongia(long dongia) {
        this.dongia = dongia;
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
