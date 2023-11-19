package com.qlvt.BTL.service;

import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Material;
import com.qlvt.BTL.model.Receipt;
import com.qlvt.BTL.repository.InvoiceDetailsRepo;
import com.qlvt.BTL.repository.MaterialRepo;
import com.qlvt.BTL.repository.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService{
    @Autowired
    private InvoiceDetailsRepo invoiceDetailsRepo;

    @Autowired
    private ReceiptRepo receiptRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @Override
    public List<InvoiceDetails> getAllInvoiceDetails() {
        return invoiceDetailsRepo.findAll();
    }

    @Override
    public List<InvoiceDetails> setInvoiceDetails(List<Receipt> list) {
        List<InvoiceDetails> details = new ArrayList<>();
        for(Receipt receipt: list){
            InvoiceDetails invoiceDetails = new InvoiceDetails();
            invoiceDetails.setThanhtien(receipt.getThanhtien());
            invoiceDetails.setSoluongnhap(receipt.getSoluongnhap());
            invoiceDetails.setNgaynhap(receipt.getNgaynhap());
            invoiceDetails.setItem(receipt.getItem());
            details.add(invoiceDetails);
            invoiceDetailsRepo.save(invoiceDetails);
        }
        receiptRepo.deleteAll();
        return details;
    }

    @Override
    public void updateQuantity(List<Receipt> list) {
        for(Receipt receipt: list){
            Material material = receipt.getItem().getMaterial();
            material.setSoluong(material.getSoluong() + receipt.getSoluongnhap());
            materialRepo.save(material);
        }
    }

    @Override
    public List<InvoiceDetails> getDetailsOfItem(long id) {
        List<InvoiceDetails> list = invoiceDetailsRepo.findAll();
        List<InvoiceDetails> show = new ArrayList<>();
        for(InvoiceDetails details: list){
            if(details.getItem().getId() == id){
                show.add(details);
            }
        }
        return show;
    }
}
