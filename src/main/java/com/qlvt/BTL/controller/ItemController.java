package com.qlvt.BTL.controller;

import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/import/{id}")
    public String itemForImport(@PathVariable(value = "id") long id, Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "import";
    }

}
