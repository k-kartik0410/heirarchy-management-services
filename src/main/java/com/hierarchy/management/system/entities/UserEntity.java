package com.hierarchy.management.system.entities;

import java.util.Optional;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
		
		@Column(name = "PHONE", nullable = false, unique = true)
		String phoneNo;
		
		@Column(name = "REFERRAL_CODE", unique = true)
		String referralCode;
		
		@ManyToOne
		@JoinColumn(name = "PARENT_ID")
		UserEntity parent;
		
		@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
		Set<UserEntity> subordinates;
		
		@Column(name = "H_LEVEL")
		int hLevel;

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

		public Optional<UserEntity> getParent() {
			return Optional.ofNullable(parent);
		}

		public void setParent(UserEntity parent) {
			this.parent = parent;
		}

		public int gethLevel() {
			return hLevel;
		}

		public void sethLevel(int hLevel) {
			this.hLevel = hLevel;
		}

		public Set<UserEntity> getSubordinates() {
			return subordinates;
		}

		public void setSubordinates(Set<UserEntity> subordinates) {
			this.subordinates = subordinates;
		}
		
		
}
