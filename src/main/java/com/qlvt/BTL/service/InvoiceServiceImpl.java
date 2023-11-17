package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDetailsRepo invoiceDetailsRepo;

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Override
    public Invoice addItemToList(Item item, int quantity) {
        Invoice invoice = new Invoice();
        List<InvoiceDetails> list = invoice.getDetails();
        InvoiceDetails invoiceDetails = findInvoiceDetails(list, item.getId());
        if(list == null){
            list = new ArrayList<>();
            if(invoiceDetails == null){
                invoiceDetails = new InvoiceDetails();
                invoiceDetails.setItem(item);
                invoiceDetails.setSoluongnhap(quantity);
                invoiceDetails.setThanhtien(quantity * item.getMaterial().getDongia() );

                invoiceDetails.setInvoice(invoice);
                list.add(invoiceDetails);
                invoiceDetailsRepo.save(invoiceDetails);

            }
        }else{

            if(invoiceDetails == null){
                invoiceDetails = new InvoiceDetails();
                invoiceDetails.setItem(item);
                invoiceDetails.setSoluongnhap(quantity);
                invoiceDetails.setThanhtien(quantity * item.getMaterial().getDongia());


                invoiceDetails.setInvoice(invoice);

                list.add(invoiceDetails);
                invoiceDetailsRepo.save(invoiceDetails);

            }
            else{
                invoiceDetails.setSoluongnhap(invoiceDetails.getSoluongnhap() + quantity);
                invoiceDetails.setThanhtien(invoiceDetails.getThanhtien() + quantity * item.getMaterial().getDongia());
//                invoiceDetails.setThanhtien(100);
                invoiceDetailsRepo.save(invoiceDetails);
            }



        }
        invoice.setDetails(list);

//            int totalItems = totalItems(invoice.getDetails());
        int totalPrice = totalPrice(invoice.getDetails());
        invoice.setTongtien(totalPrice);


        return invoiceRepo.save(invoice);
    }



    private InvoiceDetails findInvoiceDetails(List<InvoiceDetails> list, long itemID){
        if(list == null){
            return null;
        }
        InvoiceDetails invoiceDetails = null;
        for(InvoiceDetails details: list){
            if(details.getItem().getId() == itemID){
                invoiceDetails = details;
            }
        }

        return invoiceDetails;
    }

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


}
