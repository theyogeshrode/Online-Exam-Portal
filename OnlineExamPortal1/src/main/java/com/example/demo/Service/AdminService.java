package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Details.Admin;
import com.example.demo.Details.AdminDetails;
import com.example.demo.Repository.AdminRepository;


public class AdminService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByAdminEmail(username);
		if (admin == null) {
			throw new UsernameNotFoundException("Admin not found");
		}
		return new AdminDetails(admin);
	}

}
