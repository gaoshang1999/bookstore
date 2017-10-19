package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.repository.UserRepository;
import edu.mum.bookstore.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired 
	UserRepository userRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public User save(User user) {
		// TODO Auto-generated method stub
		if(user.getPassword().length() < 30) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		return userRepository.save(user);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);		
	}
	
	public void delete(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);		 
	}

	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll(new Sort(Direction.DESC, "updated"));
	}

	public List<User> query(String q) {
		// TODO Auto-generated method stub
		return userRepository.queryByUsername(q);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
