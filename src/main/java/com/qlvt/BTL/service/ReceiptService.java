package com.qlvt.BTL.service;

import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> getAllReceipt();
    Receipt getReceiptById(long id);
    void deleteReceiptById(long id);
    void deleteAllReceipt();
    void addItemToList(Item item, long quantity);
}
