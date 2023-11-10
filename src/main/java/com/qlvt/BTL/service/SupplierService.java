package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers();

    void saveSupplier(Supplier supplier);
    List<Material> getMaterialsOfSupplier();


    Supplier getSupplierById(long id);


//    public List<Material> getMaterialsById();
}
