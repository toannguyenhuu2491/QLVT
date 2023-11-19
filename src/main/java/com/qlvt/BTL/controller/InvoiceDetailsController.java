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
    private ItemService itemService;

    @Autowired
    private InvoiceService invoiceService;



    @GetMapping("/item_stats/{id}")
    public String showItemStats(@PathVariable("id") long id, Model model){
        List<InvoiceDetails> list = invoiceDetailsService.getDetailsOfItem(id);
        long supplierId = itemService.getItemById(id).getSupplier().getId();
        model.addAttribute("supplierId", supplierId);
        model.addAttribute("listDetails", list);
        return "item_stats";
    }



}
