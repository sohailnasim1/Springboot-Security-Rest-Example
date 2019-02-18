/**
 * User Repository for User Administration
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.sn.admin.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
