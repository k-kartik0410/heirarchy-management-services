package com.hierarchy.management.system.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseModel {
	
	@JsonProperty("fullName")
	private String fullName;
	
	@JsonProperty("phoneNo")
	private String phoneNo;
	
	@JsonProperty("referralCode")
	private String referralCode;
	
	@JsonProperty("parent")
	String parent;
	
	@JsonProperty("hLevel")
	int hLevel;

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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int gethLevel() {
		return hLevel;
	}

	public void sethLevel(int hLevel) {
		this.hLevel = hLevel;
	}
	
	

}
