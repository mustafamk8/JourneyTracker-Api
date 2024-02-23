package com.college.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.StudentPersonel;

public interface StudentPersonelRepo extends JpaRepository<StudentPersonel, String> {

}
