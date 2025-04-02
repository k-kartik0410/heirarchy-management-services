package com.hierarchy.management.system.model.responses;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hierarchy.management.system.entities.UserEntity;

public class UserResponseModel {
	
	@JsonProperty("fullName")
	private String fullName;
	
	@JsonProperty("phoneNo")
	private String phoneNo;
	
	@JsonProperty("referralCode")
	private String referralCode;
	
	@JsonProperty("hLevel")
	private int hLevel;
	
	@JsonProperty("subordinates")
	private Set<UserResponseModel> subordinates;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public int gethLevel() {
		return hLevel;
	}

	public void sethLevel(int hLevel) {
		this.hLevel = hLevel;
	}

	public Set<UserResponseModel> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<UserEntity> subordinates) {
		Set<UserResponseModel> users = new HashSet<>();
		for(UserEntity subordinate: subordinates) {
			UserResponseModel user = new UserResponseModel();
			user.setFullName(subordinate.getFullName());
			user.sethLevel(subordinate.gethLevel());
			user.setPhoneNo(subordinate.getPhoneNo());
			user.setReferralCode(subordinate.getReferralCode());
			user.setSubordinates(subordinate.getSubordinates());
			users.add(user);
		}
		this.subordinates = users;
	}
	
	
	
	

}
