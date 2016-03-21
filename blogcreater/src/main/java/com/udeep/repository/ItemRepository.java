package com.udeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udeep.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
