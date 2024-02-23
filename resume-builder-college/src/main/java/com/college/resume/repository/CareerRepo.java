package com.college.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Career;
import com.college.resume.entity.StudentPersonel;

public interface CareerRepo extends JpaRepository<Career, Integer>{

	
	Career findByScholarNo(StudentPersonel student);
	
}
