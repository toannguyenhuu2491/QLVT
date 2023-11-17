package com.qlvt.BTL.service;


import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.repository.ItemRepo;
import com.qlvt.BTL.repository.MaterialRepo;
import com.qlvt.BTL.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private MaterialRepo materialRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public void saveSupplier(Supplier supplier){
        this.supplierRepo.save(supplier);
    }

    @Override
    public List<Material> getMaterialsOfSupplier(Supplier supplier) {
        List<Item> items = itemRepo.findBySupplier(supplier);
        List<Material> materials = items.stream()
                .map(Item::getMaterial)
                .collect(Collectors.toList());
        return materials;
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
