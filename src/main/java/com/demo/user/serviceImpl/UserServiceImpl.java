package com.demo.user.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.user.exception.UserNotFoundException;
import com.demo.user.repository.UserRepository;
import com.demo.user.request.UserRequest;
import com.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository ;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
		
	@Override
	public String createUser(UserRequest request) {
		Optional<UserRequest> responseUser = repository.getUserByEmail(request.getEmail());
		if (responseUser.isPresent()) {
			return "User With mail ID :" + request.getEmail() + " already exist!";
		}
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		UserRequest newUser = repository.save(request);
		return "User is created With Mail ID:"+newUser.getEmail();		
	}

	@Override
	public String deleteUserByMail(String email) {
		Optional<UserRequest> findById = repository.getUserByEmail(email);
		if (findById.isPresent()) {
			UserRequest request = findById.get();
			repository.delete(request);
			return "User with Mail Id :" + email + " is Deleted";
		} else {
			throw new UserNotFoundException("User with Mail Id : " + email + " not found to delete!");
		}
		
	}

	@Override
	public List<UserRequest> getAllUser() {
		
		List<UserRequest> reposeObject = new ArrayList<UserRequest>();
		Iterable<UserRequest> optional =  repository.findAll();
		Iterator<UserRequest> iterable =   optional.iterator();
		while(iterable.hasNext()) {
			reposeObject.add(iterable.next());
		}
		return reposeObject;
	}

	@Override
	public String updateUser(UserRequest request) {
		String mailId = request.getEmail();
		Optional<UserRequest> findById = repository.getUserByEmail(mailId);
		if(findById.isPresent()) {
			UserRequest userToUpdate = findById.get();
			repository.delete(userToUpdate);
			request.setPassword(passwordEncoder.encode(request.getPassword()));
			repository.save(request);
			return "User With "+ mailId + " updated sucessfully " ;
		}else {
			throw new UserNotFoundException("User with Mail Id : " + mailId + " not found to Update !");
		}
	}

	@Override
	public UserRequest getUserByMail(String email) {
		Optional<UserRequest> findById = repository.getUserByEmail(email);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new UserNotFoundException("User with Mail Id : " + email + " not found to Update !");
		}
	}
}
