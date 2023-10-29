package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @GetMapping("/management")
    public String viewHomePage(Model model, Admin admin) {

        model.addAttribute("listMaterials", materialService.getAllMaterials());
        return "management";


    }


    @GetMapping("/showNewMaterialForm")
    public String showNewMaterialForm(Model model) {
        Material material = new Material();
        model.addAttribute("material", material);
        return "new_material";

    }

    @PostMapping("/saveMaterial")
    public String saveMaterial(@ModelAttribute("material") Material material){
        // lưu vào db
        materialService.saveMaterial(material);
        return "redirect:/management";

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        // lấy vật tư từ service
        Material material = materialService.getMaterialById(id);

        model.addAttribute("material", material);
        return "update_material";

    }

    @GetMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable (value = "id") long id){
        // xóa vật tư trong db
        this.materialService.deleteMaterialById(id);
        return "redirect:/management";
    }


}