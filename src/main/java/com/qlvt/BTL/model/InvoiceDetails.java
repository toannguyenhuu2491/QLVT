package com.qlvt.BTL.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;


@Entity
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private LocalDate ngaynhap;
    private long soluongnhap;

    private long thanhtien;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public InvoiceDetails() {
    }

    public InvoiceDetails(LocalDate ngaynhap, long soluongnhap) {
        this.ngaynhap = ngaynhap;
        this.soluongnhap = soluongnhap;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(LocalDate ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public long getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(long soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public long getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
