package com.User.service;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.User.model.User;
import com.User.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<List <User>> getAllUsers(){
		try {
			
			List<User> user= new ArrayList<User>();
			userRepository.findAll().forEach(user::add);
			if (user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (user,HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
		
	}

//	public ResponseEntity<User> getUserById(String id) {
//		Optional<User> user =userRepository.findById(id);
//		if (user.isPresent()) {
//		return new ResponseEntity<>(user.get(),HttpStatus.OK);
//		}else {
//		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
//		}
//	}

//     public ResponseEntity<User> updateUser(String id, User user) {
//		Optional<User> oldUser = userReponsitory.findById(id);
//		if (oldUser.isPresent()) {
//		User _user = oldUser.get();
//		_user.setName(newUser.getName());
//		_user.setDescribtion(newUser.getDescribtion());
//		_user.setPrice(newUser.getPrice());
//     	_user.setUrl(newUser.getUrl());
//
//		return new ResponseEntity<> (userRepository.save(_user),HttpStatus.OK);		}else {
//		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
//		}
		
		
	

//	public ResponseEntity<Map<String, Object>> getAllUserInPage(int pageNo, int pageSize, String sortBy) {
//		try {
//			Map<String, Object>response=new HashMap<>();
//			     Sort sort=Sort.by(sortBy);
//			Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
//			Page<User> page=userRepository.findAll(pageable);
//			response.put("data", page.getContent());
//			response.put("Total no of pages", page.getTotalPages());
//			response.put("Total no of elements", page.getTotalElements());
//			response.put("Current page no", page.getNumber());
//			
//			return new ResponseEntity<>(response,HttpStatus.OK);
//		    }catch(Exception e) {
//		    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//			
//		}
//		
//	}
//
//	public ResponseEntity<User> updateUser(String id, User user) {
//		
//		return null;
//	}
//
//	public ResponseEntity<User> deleteUserById(String id) {
//		try {
//			userRepository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		   }catch (Exception e) {
//			   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//	}
//
//	public ResponseEntity<Map<String, Object>> deleteUserInPage(int pageNo, int pageSize, String sortBy) {
//		// TODO Auto-generated 
//		return null;
//	}
//	

	}
