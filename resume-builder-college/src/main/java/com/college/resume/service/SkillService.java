package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.SkillDto;

public interface SkillService {

	SkillDto createSkill(SkillDto skillDto, String scholar);

	SkillDto updateSkill(SkillDto skillDto, Integer id);

	List<SkillDto> getSkillByScholar(String scholar);

	List<SkillDto> getAllSkill();

	void deleteSkill(Integer id);

}
