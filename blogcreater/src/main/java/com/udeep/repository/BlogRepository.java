package com.udeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udeep.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
