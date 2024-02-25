package com.college.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Certificate;
import com.college.resume.entity.StudentPersonel;

public interface CertificateRepo extends JpaRepository<Certificate, Integer>{

	List<Certificate> findByScholarNo(StudentPersonel student);
	
}
