package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Details.Admin;
import com.example.demo.Details.Student;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.StudentRepository;

@Controller
public class MyController {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private AdminRepository adminRepo;
	
	
	@GetMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/admin_page")
	public String adminPage() {
		return "register_admin";
	}
	@GetMapping("/over")
	public String over() {
		return "over";
	}
	
	@GetMapping("/register")
	public String setRegister(Model model) {
		model.addAttribute("student", new Student());
		
		return "signup";
	}
	
	@GetMapping("/register_admin")
	public String setAdminRegister(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "signup_admin";
	}
	
	@GetMapping("/register_student")
	public String setStudentRegister(Model model) {
		model.addAttribute("student", new Student());
		
		return "student_login";
	}
	@PostMapping("/get_admin_register")
	public String getAdminRegister(Admin admin) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(admin.getAdmin_password());
		admin.setAdmin_password(encodedPassword);
		
		adminRepo.save(admin);
		
		return "register_admin";
	}
		
	@PostMapping("/get_Student_login")
	public String getStudentRegister(Student student) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		
		return "over";
	}
	
	@PostMapping("/get_register")
	public String getRegister(Student student) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		
		studentRepo.save(student);
		
		return "register";
	}
	
	
	@GetMapping("/students")
	public String liststudents(Model model) {
		List<Student> liststudents = studentRepo.findAll();
		model.addAttribute("liststudents", liststudents);
		
		return "students";
	}
	
	
}