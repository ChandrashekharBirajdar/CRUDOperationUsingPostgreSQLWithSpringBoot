package com.demo.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.request.UserRequest;
import com.demo.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService services;
	
	
	@GetMapping(path = "/getAllUser" ,
			produces =  {MediaType.APPLICATION_JSON_VALUE})
	public List<UserRequest> getAllUser(){
		return services.getAllUser();
		
	}

	@GetMapping(path = "/getByMail/{email}")
	public UserRequest getUserByMail(@PathVariable String email) {
		return services.getUserByMail(email);
	}
	
	@PostMapping(path = "/createUser" ,  consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public String createUser(@Valid @RequestBody UserRequest request) {
		return services.createUser(request);
	}

	@DeleteMapping(path = "/delete/{email}")
	public String deleteUserByMail(@PathVariable String email) {

		return services.deleteUserByMail(email);

	}
	
	@PutMapping(path = "/update" , consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public String updateUser(@RequestBody UserRequest request) {
		return services.updateUser(request);
	}
	
	
}
