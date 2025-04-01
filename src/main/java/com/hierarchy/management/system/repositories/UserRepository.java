package com.hierarchy.management.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hierarchy.management.system.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	public UserEntity getByReferralCode(String referralCode);
	
	public UserEntity getByPhoneNo(String phoneNo);

	
}
