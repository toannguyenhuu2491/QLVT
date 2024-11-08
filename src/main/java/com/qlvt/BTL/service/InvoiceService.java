package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InvoiceService {
    List<Invoice> getAllInvoice();
    Invoice getInvoiceById(long id);
    void saveInvoice(List<InvoiceDetails> details);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(long id);
}
