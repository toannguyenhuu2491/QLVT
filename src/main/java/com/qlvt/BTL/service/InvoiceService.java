package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Invoice;
import com.qlvt.BTL.model.InvoiceDetails;
import com.qlvt.BTL.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InvoiceService {
    Invoice addItemToList(Item item, int quantity);
}
