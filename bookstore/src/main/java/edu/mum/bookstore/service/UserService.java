package edu.mum.bookstore.service;

import java.util.List;

import edu.mum.bookstore.domain.User;

 

public interface UserService {
	
	public User save(User user);	
	
	public void delete(Integer id);	
	
	public void delete(User user);	
	
	public User update(User user);	
	
	public User findOne(Integer id);	
	
	public List<User> getAll();
	
	public List<User> query(String q);
	
	public User findByUsername(String username);	
}
