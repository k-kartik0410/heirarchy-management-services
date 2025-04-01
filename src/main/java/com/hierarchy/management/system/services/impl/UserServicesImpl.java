package com.hierarchy.management.system.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hierarchy.management.system.entities.UserEntity;
import com.hierarchy.management.system.exceptions.InvalidReferralCodeException;
import com.hierarchy.management.system.model.requests.UserRequestModel;
import com.hierarchy.management.system.repositories.UserRepository;
import com.hierarchy.management.system.services.UserService;

@Service
public class UserServicesImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUserByPhoneNo(String PhoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity adduser(UserRequestModel userRequest) throws InvalidReferralCodeException{
		String referralCode = UUID.randomUUID().toString().split("-")[0];
		
		
		UserEntity parent = userRepository.getByReferralCode(userRequest.getReferralCode());
		if(null == parent)
			throw new InvalidReferralCodeException("Invalid Referral Code Provided");
		
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFullName(userRequest.getFullName());
		userEntity.setPhoneNo(userRequest.getPhoneNo());
		userEntity.setReferralCode(referralCode);
		userEntity.setParentId(parent.getId());
		userEntity.sethLevel(parent.gethLevel()+1);
		
		userRepository.save(userEntity);
		
		return userEntity;
	}

}
