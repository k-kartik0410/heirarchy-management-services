package com.hierarchy.management.system.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;

public class UserRequestModel {
	
	@JsonProperty("fullName")
	@Nonnull
	private String fullName;
	
	@JsonProperty("phoneNo")
	@Nonnull
	private String phoneNo;
	
	@JsonProperty("referralCode")
	private String referralCode;
	
	@JsonProperty("isRoot")
	private boolean isRoot;
	
	public UserRequestModel() {
		super();
	}

	public UserRequestModel(String fullName, String phoneNo, String referralCode) {
		super();
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.referralCode = referralCode;
	}

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

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	
	
	
	

}
