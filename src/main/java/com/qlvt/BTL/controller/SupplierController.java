package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.service.MaterialService;
import com.qlvt.BTL.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @Autowired
    private MaterialService materialService;

    @GetMapping("/suppliers")
    public String viewHomePage(Model model) {
        model.addAttribute("listSuppliers", supplierService.getAllSuppliers());
        return "suppliers";


    }

    @GetMapping("/choose_material")
    public String chooseMaterial(Model model){
        model.addAttribute("listMaterials", materialService.getAllMaterials());
        return "choose_material";
    }

//    @GetMapping("/chooseMaterial/{id}")
//    public String chooseMaterial(@PathVariable(value = "id") long id, Model model){
//       model.addAttribute(supplierService.getMaterialsOfSupplier());
//       return "chooseMaterial";
//    }
}