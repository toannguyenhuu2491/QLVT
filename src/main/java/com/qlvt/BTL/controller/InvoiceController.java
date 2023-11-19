package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.*;
import com.qlvt.BTL.service.InvoiceDetailsService;
import com.qlvt.BTL.service.InvoiceService;
import com.qlvt.BTL.service.ItemService;
import com.qlvt.BTL.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/saveInvoice")
    public String saveInvoice(){
        List<Receipt> list = receiptService.getAllReceipt();
        invoiceDetailsService.updateQuantity(list);
        List<InvoiceDetails> details = invoiceDetailsService.setInvoiceDetails(list);
        invoiceService.saveInvoice(details);
        return "redirect:/home";
    }


    @GetMapping("/invoice_list")
    public String invoiceList(Model model){
        List<Invoice> list = invoiceService.getAllInvoice();
        model.addAttribute("ListInvoice", list);
        return "invoice_list";
    }


    @GetMapping("/invoice/{id}")
    public String showInvoice(@PathVariable(value = "id") long id, Model model){
        Invoice invoice = invoiceService.getInvoiceById(id);
        List<InvoiceDetails> invoiceDetails = invoice.getDetails();
        model.addAttribute("invoice", invoice);
        model.addAttribute("invoiceDetails", invoiceDetails);
        return "invoice";
    }

    @PostMapping("/payInvoice")
    public String payInvoice(@RequestParam("invoiceId") long id ){
        Invoice update = invoiceService.getInvoiceById(id);
        invoiceService.updateInvoice(update);
        return "redirect:/invoice_list";
    }

}
