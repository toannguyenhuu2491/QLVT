package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.service.InvoiceDetailsService;
import com.qlvt.BTL.service.InvoiceService;
import com.qlvt.BTL.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @Autowired
    private ItemService itemService;


    @GetMapping("/importList")
    public String showInvoice(Model model){
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "import_list";
    }

    @PostMapping("/importMaterial")
    public String importMaterial(@RequestParam("supplierId") long supplierId,
                                 @RequestParam(value = "quantity", defaultValue = "0") int quantity,
                                 @ModelAttribute("item") Item item){
        Item newItem = itemService.getItemById(item.getId());
        Invoice invoice = invoiceService.addItemToList(newItem, quantity);
        return "redirect:/supplier/" + supplierId;
    }

//
//    @PostMapping("/import")

}
