package com.qlvt.BTL.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate ngayxuat;
    private long tongtien;
    private String trangthai;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetails> details = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(LocalDate ngayxuat, long tongtien, String trangthai, List<InvoiceDetails> details) {
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

    public LocalDate getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(LocalDate ngayxuat) {
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
