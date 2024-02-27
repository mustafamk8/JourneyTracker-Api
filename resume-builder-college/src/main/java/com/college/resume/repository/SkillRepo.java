package com.college.resume.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.college.resume.entity.Skill;
import com.college.resume.entity.StudentPersonel;

public interface SkillRepo extends JpaRepository<Skill, Integer>{
	List<Skill> findByScholarNo(StudentPersonel student);


}
