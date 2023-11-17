package com.qlvt.BTL.model;


import jakarta.persistence.*;

import java.util.*;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date ngayxuat;
    private long tongtien;
    private String trangthai;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.MERGE)
    private List<InvoiceDetails> details = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(Date ngayxuat, long tongtien, String trangthai, List<InvoiceDetails> details) {
        this.ngayxuat = ngayxuat;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
        this.details = details;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public List<InvoiceDetails> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetails> details) {
        this.details = details;
    }


}
