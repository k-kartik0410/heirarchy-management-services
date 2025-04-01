package com.hierarchy.management.system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hierarchy.management.system.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	public Optional<UserEntity> getByReferralCode(String referralCode);
	
	public Optional<UserEntity> getByPhoneNo(String phoneNo);
	
}
