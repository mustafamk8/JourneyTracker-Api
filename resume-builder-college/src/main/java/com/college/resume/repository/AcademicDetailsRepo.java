package com.college.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.AcademicDetails;
import com.college.resume.entity.StudentPersonel;

public interface AcademicDetailsRepo extends JpaRepository<AcademicDetails, Integer>{

	AcademicDetails findByScholarNo(StudentPersonel student);
	
}
