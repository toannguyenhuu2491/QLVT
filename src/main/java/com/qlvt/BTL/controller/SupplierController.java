package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Admin;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.service.MaterialService;
import com.qlvt.BTL.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @Autowired
    private MaterialService materialService;




    @GetMapping("/showNewSupplierForm")
    public String showNewMaterialForm(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "new_supplier";

    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier){

        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";

    }

//    @GetMapping("/choose_material")
//    public String chooseMaterial(Model model, Supplier supplier){
//        model.addAttribute("listMaterials", supplierService.getMaterialsOfSupplier(supplier));
//        return "choose_material";
//    }

    @GetMapping("/suppliers")
    public String viewSuppliersList(Model model) {
        model.addAttribute("listSuppliers", supplierService.getAllSuppliers());
        return "suppliers";


    }

    @GetMapping("/supplier/{id}")
    public String materialsFromSupplier(@PathVariable(value = "id") long id, Model model){
        Supplier supplier = supplierService.getSupplierById(id);
        List<Item> items = supplier.getItem();
        model.addAttribute("supplier", supplier);
        model.addAttribute("items", items);
//        List<Material> materials = supplierService.getMaterialsOfSupplier(supplier);
//        model.addAttribute("materials", materials);
        return "choose_material";

    }

    @GetMapping("/supplier_stats")
    public String viewStatistic(Model model) {
        model.addAttribute("listSuppliers", supplierService.getAllSuppliers());
        return "supplier_stats";
    }

    @GetMapping("/supplier_stats/{id}")
    public String materialsListFromSupplier(@PathVariable(value = "id") long id, Model model){
        Supplier supplier = supplierService.getSupplierById(id);
        List<Item> items = supplier.getItem();
        model.addAttribute("items", items);
        return "supplier_items";

    }

}
