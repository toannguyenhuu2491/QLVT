package com.qlvt.BTL.repository;

import com.qlvt.BTL.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
