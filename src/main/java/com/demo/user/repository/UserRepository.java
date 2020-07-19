package com.demo.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.request.UserRequest;

@Repository
public interface UserRepository extends CrudRepository<UserRequest, Long> {
	
	Optional<UserRequest> getUserByEmail(String email);
	

}
