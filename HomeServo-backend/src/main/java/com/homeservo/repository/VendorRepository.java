package com.homeservo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeservo.dto.Customer;
import com.homeservo.dto.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	public Vendor findByEmail(String email);
	public  List<Vendor> findAll();

}
