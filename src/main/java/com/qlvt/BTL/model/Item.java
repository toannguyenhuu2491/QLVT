package com.qlvt.BTL.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    @JoinColumn(name = "material_id")
    private Material material;


    @ManyToOne
    @Cascade(CascadeType.MERGE)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    @OneToOne(mappedBy = "item")
    private InvoiceDetails invoiceDetails;

    public Item() {
    }

    public Item(Material material, Supplier supplier) {
        this.material = material;
        this.supplier = supplier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public InvoiceDetails getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}
