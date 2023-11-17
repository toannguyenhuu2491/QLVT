package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MaterialService {
    List<Material> getAllMaterials();
    void saveMaterial(Material material);


    Material getMaterialById(long id);
    void deleteMaterialById(long id);

    void addNewMaterial(Material newMaterial, Supplier supplier);
}
