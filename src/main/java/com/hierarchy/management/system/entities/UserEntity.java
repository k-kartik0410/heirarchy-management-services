package com.hierarchy.management.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "ID")
		String id;
		
		@Column(name = "FULL_NAME", nullable = false)
		String fullName;
		
		@Column(name = "PHONE", nullable = false)
		String phoneNo;
		
		@Column(name = "REFERRAL_CODE")
		String referralCode;
		
		@Column(name = "PARENT_ID")
		String parent;
		
		@Column(name = "H_LEVEL")
		int hLevel;
		
		public UserEntity() {
			super();
		}

		public UserEntity(String fullName, String phoneNo, String referralCode, String parent, int hLevel) {
			super();
			this.fullName = fullName;
			this.phoneNo = phoneNo;
			this.referralCode = referralCode;
			this.parent = parent;
			this.hLevel = hLevel;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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

		public String getParentId() {
			return parent;
		}

		public void setParentId(String parentId) {
			this.parent = parentId;
		}

		public int gethLevel() {
			return hLevel;
		}

		public void sethLevel(int hLevel) {
			this.hLevel = hLevel;
		}
}
