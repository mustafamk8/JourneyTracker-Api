package com.college.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Internship;
import com.college.resume.entity.StudentPersonel;

public interface InternshipRepo extends JpaRepository<Internship, Integer>{
	
	List<Internship> findByScholarNo(StudentPersonel student);

}
