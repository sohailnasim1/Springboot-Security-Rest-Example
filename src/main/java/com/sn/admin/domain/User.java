/**
 * Entity class for User. Getters and Settings are injected by lombok.Data
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(updatable=false)
	private String username;
	private String password;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="emailaddress")
	private String emailAddress;
	@Column(insertable=false)
	private String active;
}
