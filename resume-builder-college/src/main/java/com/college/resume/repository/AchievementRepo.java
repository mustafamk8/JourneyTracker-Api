package com.college.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.resume.entity.Achievement;
import com.college.resume.entity.Career;
import com.college.resume.entity.StudentPersonel;

public interface AchievementRepo extends JpaRepository<Achievement, Integer> {
	
	List<Achievement> findByScholarNo(StudentPersonel student);
	
}
