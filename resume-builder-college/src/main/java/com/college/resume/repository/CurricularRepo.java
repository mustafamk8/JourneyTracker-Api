package com.college.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Curricular;
import com.college.resume.entity.StudentPersonel;

public interface CurricularRepo extends JpaRepository<Curricular, Integer>{
	
	List<Curricular> findByScholarNo(StudentPersonel student);

}
