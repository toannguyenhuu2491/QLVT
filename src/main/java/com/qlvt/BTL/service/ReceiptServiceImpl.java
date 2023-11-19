package com.qlvt.BTL.service;


import com.qlvt.BTL.model.Receipt;
import com.qlvt.BTL.model.Receipt;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Receipt;
import com.qlvt.BTL.repository.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepo receiptRepo;

    @Override
    public List<Receipt> getAllReceipt() {
        return receiptRepo.findAll();
    }

    @Override
    public Receipt getReceiptById(long id) {
        Optional<Receipt> optional = receiptRepo.findById(id);
        Receipt receipt = null;
        if(optional.isPresent()){
            receipt = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy");

        }
        return receipt;
    }

    @Override
    public void deleteReceiptById(long id) {
        receiptRepo.deleteById(id);
    }

    @Override
    public void deleteAllReceipt() {
        receiptRepo.deleteAll();
    }

    @Override
    public void addItemToList( Item item, long quantity) {
        List<Receipt> list = receiptRepo.findAll();
        Receipt receipt = findReceipt(list, item.getId());
        if(list == null){
            list = new ArrayList<>();
            if(receipt == null){
                receipt = new Receipt();
                receipt.setItem(item);
                receipt.setNgaynhap(LocalDate.now());
                receipt.setSoluongnhap(quantity);
                receipt.setThanhtien(quantity * item.getMaterial().getDongia() );
                receiptRepo.save(receipt);
            }
        }else{
            if(receipt == null){
                receipt = new Receipt();
                receipt.setItem(item);
                receipt.setNgaynhap(LocalDate.now());
                receipt.setSoluongnhap(quantity);
                receipt.setThanhtien(quantity * item.getMaterial().getDongia());
                receiptRepo.save(receipt);

            }
            else{
                receipt.setSoluongnhap(receipt.getSoluongnhap() + quantity);
                receipt.setThanhtien(receipt.getThanhtien() + quantity * item.getMaterial().getDongia());
                receiptRepo.save(receipt);
            }
        }

    }


    private Receipt findReceipt(List<Receipt> list, long itemID){
        if(list == null){
            return null;
        }
        Receipt receipt = null;
        for(Receipt r: list){
            if(r.getItem().getId() == itemID){
                receipt = r;
            }
        }

        return receipt;
    }
    
}
