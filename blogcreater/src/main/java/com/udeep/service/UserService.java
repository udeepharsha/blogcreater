package com.udeep.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.udeep.repository.BlogRepository;
import com.udeep.repository.ItemRepository;
import com.udeep.repository.UserRepository;
import com.udeep.entity.Blog;
import com.udeep.entity.Item;
import com.udeep.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public BlogRepository blogRepository;
	
	@Autowired
	public ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog , new PageRequest(0, 10, Direction.DESC, "publishedDate") );
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
