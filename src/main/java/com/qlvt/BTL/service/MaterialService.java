package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    List<Material> getAllMaterials();
    void saveMaterial(Material material);

    Material getMaterialById(long id);
    void deleteMaterialById(long id);
}
