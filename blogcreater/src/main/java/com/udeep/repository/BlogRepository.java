package com.udeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udeep.entity.Blog;
import com.udeep.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);
	
}
