package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class InvoiceDetailsController {
    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/import/{id}")
    public String itemForImport(@PathVariable(value = "id") long id, Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "import";
    }

//    @GetMapping("/importList")
//    public String listInvoiceDetails(Model model){
//        List<InvoiceDetails> list = invoiceDetailsService.getAllInvoiceDetails();
//        model.addAttribute("listInvoiceDetails", list);
//        return "import_list";
//    }



}
