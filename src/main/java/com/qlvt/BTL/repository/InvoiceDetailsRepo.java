package com.qlvt.BTL.repository;


import com.qlvt.BTL.model.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceDetailsRepo extends JpaRepository<InvoiceDetails, Long> {
}
