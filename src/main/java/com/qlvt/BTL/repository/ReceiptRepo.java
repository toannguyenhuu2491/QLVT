package com.qlvt.BTL.repository;

import com.qlvt.BTL.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo extends JpaRepository<Receipt, Long> {
}
