package com.udeep.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.udeep.entity.Blog;
import com.udeep.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog , Pageable pageable);
	
}
