/**
 * Service bean for User Administration
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.admin.domain.User;
import com.sn.admin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(String username) {
		return userRepository.findById(username);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
	

}
