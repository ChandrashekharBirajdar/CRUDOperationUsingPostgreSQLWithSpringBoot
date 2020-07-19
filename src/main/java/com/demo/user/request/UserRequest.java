package com.demo.user.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "new_demo_user")
public class UserRequest {

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 4 , message = "user name should be more than 4 character")
	@Column
	private String userName ;
	
	@NotNull
	@Size(min = 4  , message = "password should be more than 4 and less than 8 character")
	@Column
	private String password ;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email ;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
