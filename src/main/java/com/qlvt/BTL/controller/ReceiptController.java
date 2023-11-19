package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Receipt;
import com.qlvt.BTL.service.ItemService;
import com.qlvt.BTL.service.ReceiptService;
import com.qlvt.BTL.service.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/importList/{id}")
    public String showImportList(@PathVariable(value = "id") long id, Model model){
        List<Receipt> receiptList = receiptService.getAllReceipt();
        model.addAttribute("supplierId", id);
        model.addAttribute("receiptList",receiptList);
        return "import_list";
    }

    @GetMapping("/deleteReceipt/{id}")
    public String deleteReceipt(@PathVariable(value = "id") long id){
        Receipt receipt = receiptService.getReceiptById(id);
        long supplierId = receipt.getItem().getSupplier().getId();
        receiptService.deleteReceiptById(id);
        return "redirect:/importList/" + supplierId;
    }


    @GetMapping("/cancelReceipt")
    public String cancelReceipt(Model model){
        receiptService.deleteAllReceipt();
        return "redirect:/suppliers";
    }

    @PostMapping("/importMaterial")
    public String importMaterial(@RequestParam("supplierId") long supplierId,
                                 @RequestParam(value = "quantity", defaultValue = "0") int quantity,
                                 @ModelAttribute("item") Item item){
        Item saveItem = itemService.getItemById(item.getId());

        receiptService.addItemToList(saveItem, quantity);
        return "redirect:/supplier/" + supplierId;
    }
}
