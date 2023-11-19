package com.qlvt.BTL.service;

import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Receipt;

import java.util.List;

public interface InvoiceDetailsService {
    List<InvoiceDetails> getAllInvoiceDetails();

    List<InvoiceDetails> setInvoiceDetails(List<Receipt> list);

    void updateQuantity(List<Receipt> list);

    List<InvoiceDetails> getDetailsOfItem(long id);
}
