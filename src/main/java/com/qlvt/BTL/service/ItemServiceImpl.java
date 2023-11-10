package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Supplier;
import com.qlvt.BTL.repository.ItemRepo;
import com.qlvt.BTL.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private MaterialRepo materialRepo;
    @Autowired
    private ItemRepo itemRepo;


}
