package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.repository.ItemRepo;
import com.qlvt.BTL.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private MaterialRepo materialRepo;
    @Autowired
    private ItemRepo itemRepo;




    @Override
    public Item getItemById(long id) {
        Optional<Item> optional = itemRepo.findById(id);
        Item item = null;
        if(optional.isPresent()){
            item = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy hàng nhập");

        }
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
}
