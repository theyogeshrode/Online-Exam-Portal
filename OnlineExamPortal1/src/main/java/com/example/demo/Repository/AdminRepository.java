package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Details.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("SELECT u FROM Admin u WHERE u.admin_email = ?1")
	public Admin findByAdminEmail(String admin_email);
	
}