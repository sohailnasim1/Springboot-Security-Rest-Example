/**
 * Rest controller for User Administration
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sn.admin.domain.User;
import com.sn.admin.exception.NotFoundException;
import com.sn.admin.service.UserService;


@RequestMapping(path = "/users", produces = "application/json")
@CrossOrigin(origins = "*")
@RestController
public class UserAdminController {

	@Autowired
	private UserService userService;
	
	/**
	 * Returns all users
	 * @return
	 */
	@GetMapping
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	
	/**
	 * Return a user specified by path variable
	 * @param username
	 * @return
	 */

	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		Optional<User> user = userService.getUser(username);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Adds new user
	 * @param user
	 * @return
	 */
	@PostMapping(consumes="application/json")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		Optional<User> userOp = userService.getUser(user.getUsername());
		if (userOp.isPresent()) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
		
	}
	
	/**
	 * Updates existing user
	 * @param username
	 * @param updatedUser
	 * @return
	 */
	@PatchMapping(path = "/{username}", consumes = "application/json")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User updatedUser) {
		Optional<User> userOp = userService.getUser(username);
		if (userOp.isPresent()) {
			User user = userOp.get();
			if (!updatedUser.getFirstName().equals(user.getFirstName())) {
				user.setFirstName(updatedUser.getFirstName());
			}
			if (!updatedUser.getLastName().equals(user.getLastName())) {
				user.setLastName(updatedUser.getLastName());
			}

			if (!updatedUser.getEmailAddress().equals(user.getEmailAddress())) {
				user.setEmailAddress(updatedUser.getEmailAddress());
			}
			return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Deletes existing user
	 * @param username
	 */
	@DeleteMapping("/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("username") String username) {
		try {
			userService.deleteUser(username);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("User not found:" + username);
		}
	}

	/**private void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}*/

}
