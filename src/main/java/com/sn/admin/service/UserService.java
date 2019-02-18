/**
 * Service interface for User Administration
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.service;

import java.util.Optional;

import com.sn.admin.domain.User;

public interface UserService {
	
	Iterable<User> getUsers();
	
	Optional<User> getUser(String username);
	
	User saveUser(User user);
	
	public void deleteUser(String username);
}
