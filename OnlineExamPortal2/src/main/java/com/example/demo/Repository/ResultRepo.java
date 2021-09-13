package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}
