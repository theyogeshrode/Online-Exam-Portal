package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Details.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT u FROM Student u WHERE u.email = ?1")
	public Student findByEmail(String email);
	
}
