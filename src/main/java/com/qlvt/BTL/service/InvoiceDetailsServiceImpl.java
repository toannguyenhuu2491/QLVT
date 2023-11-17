package com.qlvt.BTL.service;

import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.repository.InvoiceDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService{
    @Autowired
    private InvoiceDetailsRepo invoiceDetailsRepo;


    @Override
    public List<InvoiceDetails> getAllInvoiceDetails() {
        return invoiceDetailsRepo.findAll();
    }
}
