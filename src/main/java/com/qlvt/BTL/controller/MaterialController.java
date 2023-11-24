package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.*;
import com.qlvt.BTL.service.ItemService;
import com.qlvt.BTL.service.MaterialService;
import com.qlvt.BTL.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ItemService itemService;



    // CRUD

    @GetMapping("/showNewMaterialForm")
    public String showNewMaterialForm(Model model) {
        Material material = new Material();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("material", material);
        model.addAttribute("suppliers", suppliers);
        return "new_material";

    }

    // Thêm vật tư
    @PostMapping("/saveMaterial")
    public String saveMaterial(@ModelAttribute("newMaterial") Material newMaterial, @RequestParam("supplier.id") Long supplierId) {
        Supplier supplier = supplierService.getSupplierById(supplierId);
        materialService.addNewMaterial(newMaterial, supplier);
        return "redirect:/management";

    }

    // Sửa vật tư
    @PostMapping("/updateMaterial")
    public String updateMaterial(@ModelAttribute("material") Material material){
        materialService.updateMaterial(material);
        return "redirect:/management";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Material material = materialService.getMaterialById(id);
        model.addAttribute("material", material);
        return "update_material";
    }

    @GetMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable (value = "id") long id){
        materialService.deleteMaterialById(id);
        return "redirect:/management";
    }


}