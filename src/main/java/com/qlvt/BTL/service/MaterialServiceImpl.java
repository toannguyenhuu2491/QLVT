package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialRepo materialRepo;

    @Override
    public List<Material> getAllMaterials() {
        return materialRepo.findAll();
    }

    @Override
    public void saveMaterial(Material material) {
        this.materialRepo.save(material);
    }

    @Override
    public Material getMaterialById(long id) {
        Optional<Material> optional = materialRepo.findById(id);
        Material material = null;
        if(optional.isPresent()){
            material = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy vật tư");

        }
        return material;
    }

    @Override
    public void deleteMaterialById(long id) {
        this.materialRepo.deleteById(id);
    }


}