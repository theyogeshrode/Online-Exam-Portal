package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Details.Student;
import com.example.demo.Details.StudentDetails;
import com.example.demo.Repository.StudentRepository;

public class StudentService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepo.findByEmail(username);
		if (student == null) {
			throw new UsernameNotFoundException("Student not found");
		}
		return new StudentDetails(student);
	}

}
