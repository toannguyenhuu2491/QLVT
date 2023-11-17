package com.qlvt.BTL.repository;

import com.qlvt.BTL.model.Item;
import com.qlvt.BTL.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findBySupplier(Supplier supplier);
}
