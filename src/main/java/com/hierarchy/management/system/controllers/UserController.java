package com.hierarchy.management.system.controllers;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<UserRequestModel> registerUser(@RequestBody UserRequestModel userRequest){
		
		try {
			UserEntity userEntity = userService.adduser(userRequest);
		
			UserRequestModel userResponseModel = new UserRequestModel(userEntity.getFullName(), 
				userEntity.getPhoneNo(), 
				userEntity.getReferralCode());
		
		
			return new ResponseEntity<UserRequestModel>(userResponseModel, HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			UserRequestModel userResponseModel = new UserRequestModel();
			return new ResponseEntity<UserRequestModel>(userResponseModel, HttpStatus.BAD_REQUEST);
		}
		
		

	} 
	
	@GetMapping("/{phoneNo}")
	public ResponseEntity<UserResponseModel> getUsers(@PathVariable String phoneNo){
		
		UserResponseModel userResponseModel = new UserResponseModel();
		UserEntity userEntity = userService.getUserByPhoneNo(phoneNo);
		userResponseModel.setFullName(userEntity.getFullName());
		userResponseModel.setParent(userEntity.getParentId());
		userResponseModel.setPhoneNo(userEntity.getPhoneNo());
		userResponseModel.sethLevel(userEntity.gethLevel());
		userResponseModel.setReferralCode(userEntity.getReferralCode());
		ResponseEntity<UserResponseModel> usersResponse = new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		return usersResponse;
		
	}
	
	
}
