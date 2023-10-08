	package com.homeservo.dto;
	
	import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
	@Entity
	@Data
	public class Customer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		@Column(unique = true)
		private String email;
		@Column(columnDefinition = "BIGINT")
     	private long phone;
		private String password;
		private int familyCount; 
		
		@OneToOne(cascade = CascadeType.ALL)
		private Address address;
	
		@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
		private List<Work> works;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getFamilyCount() {
			return familyCount;
		}
		public void setFamilyCount(int familyCount) {
			this.familyCount = familyCount;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public List<Work> getWorks() {
			return works;
		}
		public void setWorks(List<Work> works) {
			this.works = works;
		}
		
		
	
	}
