package com.example.demo.Details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class AdminDetails implements UserDetails{
	
private Admin admin;
	
	public AdminDetails(Admin admin) {
		this.admin=admin;
	
	}


	@Override
	public String getPassword() {
		return admin.getAdmin_password();
	}

	@Override
	public String getUsername() {
		return admin.getAdmin_email();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	



}
