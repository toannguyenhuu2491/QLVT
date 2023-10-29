package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers();

    List<Material> getMaterialsOfSupplier();
//    public List<Material> getMaterialsById();
}
