package com.hierarchy.management.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchy.management.system.entities.UserEntity;
import com.hierarchy.management.system.exceptions.InvalidReferralCodeException;
import com.hierarchy.management.system.model.requests.UserRequestModel;
import com.hierarchy.management.system.model.responses.UserResponseModel;
import com.hierarchy.management.system.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseModel> registerUser(@RequestBody UserRequestModel userRequest) {

		UserEntity userEntity = userService.adduser(userRequest);

		UserResponseModel userResponseModel = new UserResponseModel();
		userResponseModel.setFullName(userEntity.getFullName());
		userResponseModel.setReferralCode(userEntity.getReferralCode());
		userResponseModel.setPhoneNo(userEntity.getPhoneNo());
		
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.CREATED);

	} 
	
	@GetMapping("/{phoneNo}")
	public ResponseEntity<UserResponseModel> validateUser(@PathVariable String phoneNo){
		
		UserResponseModel userResponseModel = new UserResponseModel();
		UserEntity userEntity = userService.getUserByPhoneNo(phoneNo).get();
		if(null == userEntity.getId() || userEntity.getId().isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
		}
		userResponseModel.setFullName(userEntity.getFullName());
		userResponseModel.setPhoneNo(userEntity.getPhoneNo());
		userResponseModel.sethLevel(userEntity.gethLevel());
		userResponseModel.setReferralCode(userEntity.getReferralCode());
		userResponseModel.setSubordinates(userEntity.getSubordinates());
		ResponseEntity<UserResponseModel> usersResponse = new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		
		
		return usersResponse;
		
	}
	
	
}
