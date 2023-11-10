package com.qlvt.BTL.service;


import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.repository.MaterialRepo;
import com.qlvt.BTL.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void saveSupplier(Supplier supplier){
        this.supplierRepo.save(supplier);
    }

    @Override
    public List<Material> getMaterialsOfSupplier() {
        return materialRepo.findAll();
    }

    @Override
    public Supplier getSupplierById(long id) {
        Optional<Supplier> optional = supplierRepo.findById(id);
        Supplier supplier = null;
        if(optional.isPresent()){
            supplier = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy nhà cung cấp");

        }
        return supplier;
    }

}
