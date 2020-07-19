package com.demo.user.service;

import java.util.List;

import com.demo.user.request.UserRequest;

public interface UserService {
	
	String createUser(UserRequest request);
	
	String deleteUserByMail(String email);
	
	List<UserRequest> getAllUser();

	String updateUser(UserRequest request);
	
	UserRequest getUserByMail(String email);
}
