package com.college.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Project;
import com.college.resume.entity.StudentPersonel;

public interface ProjectRepo extends JpaRepository<Project, Integer>{

	List<Project> findByScholarNo(StudentPersonel student);
	
}
