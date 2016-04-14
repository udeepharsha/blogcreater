package com.udeep.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udeep.repository.BlogRepository;
import com.udeep.repository.ItemRepository;
import com.udeep.repository.RoleRepository;
import com.udeep.repository.UserRepository;
import com.udeep.entity.Blog;
import com.udeep.entity.Item;
import com.udeep.entity.Role;
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
	
	@Autowired
	public RoleRepository roleRepository;
	
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
	public User findOneWithBlogs(String name){
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
		
	}
	

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.delete(id);	
	}
	
	public User findOne(String username) {
		return userRepository.findByName(username);
	}

}
