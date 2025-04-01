package com.hierarchy.management.system.services;

import org.springframework.stereotype.Service;

import com.hierarchy.management.system.entities.UserEntity;
import com.hierarchy.management.system.exceptions.InvalidReferralCodeException;
import com.hierarchy.management.system.model.requests.UserRequestModel;

@Service
public interface UserService {

	public UserEntity addUser(UserEntity user);
	public UserEntity adduser(UserRequestModel user) throws InvalidReferralCodeException;
	public UserEntity getUser(String id);
	public UserEntity getUserByPhoneNo(String PhoneNo);
	
}
