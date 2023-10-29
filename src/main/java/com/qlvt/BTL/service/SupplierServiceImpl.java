package com.qlvt.BTL.service;


import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.repository.MaterialRepo;
import com.qlvt.BTL.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private MaterialRepo materialRepo;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public List<Material> getMaterialsOfSupplier() {
        return materialRepo.findAll();
    }

}
