package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDetailsRepo invoiceDetailsRepo;

    @Autowired
    private InvoiceRepo invoiceRepo;





//    private int totalItems(List<InvoiceDetails> list){
//        int totalQuantity = 0;
//        for(InvoiceDetails invoiceDetails: list){
//            totalQuantity += invoiceDetails.getSoluongnhap();
//        }
//        return totalQuantity;
//    }


    private int totalPrice(List<InvoiceDetails> list){
        int totalPrice = 0;
        for(InvoiceDetails invoiceDetails: list){
            totalPrice += invoiceDetails.getThanhtien();
        }
        return totalPrice;
    }


    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepo.findAll();
    }

    @Override
    public Invoice getInvoiceById(long id) {
        Optional<Invoice> optional = invoiceRepo.findById(id);
        Invoice invoice = null;
        if(optional.isPresent()){
            invoice = optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy hóa đơn");

        }
        return invoice;
    }

    @Override
    public void saveInvoice(List<InvoiceDetails> details) {
        Invoice invoice = new Invoice();
        invoice.setTongtien(totalPrice(details));
        invoice.setNgayxuat(LocalDate.now());
        invoice.setTrangthai("Chưa thanh toán");
        for(InvoiceDetails invoiceDetails: details){
            invoiceDetails.setInvoice(invoice);
        }
        invoiceRepo.save(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        invoice.setTrangthai("Đã thanh toán");
        invoiceRepo.save(invoice);
    }
}
