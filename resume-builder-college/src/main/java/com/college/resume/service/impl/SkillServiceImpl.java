package com.college.resume.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.resume.entity.Skill;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.payloads.SkillDto;
import com.college.resume.repository.SkillRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private SkillRepo skillRepo;
	
	@Override
	public SkillDto createSkill(SkillDto skillDto, String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		Skill skill = this.dtoToSkill(skillDto);
		skill.setScholarNo(student);
		Skill savedSkill = this.skillRepo.save(skill);
		return this.skillToDto(savedSkill);
	}

	@Override
	public SkillDto updateSkill(SkillDto skillDto, Integer id) {
		Skill skill = this.skillRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Skill", "Id", id));
		skill.setSkillName(skillDto.getSkillName());
		Skill updatedSkill = this.skillRepo.save(skill);
		return this.skillToDto(updatedSkill);
	}

	@Override
	public List<SkillDto> getSkillByScholar(String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		List<Skill> skillList = this.skillRepo.findByScholarNo(student);
		List<SkillDto> list = skillList.stream().map(skill -> this.skillToDto(skill))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<SkillDto> getAllSkill() {
		List<Skill> skillList = this.skillRepo.findAll();
		List<SkillDto> list = skillList.stream().map(skill -> this.skillToDto(skill))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteSkill(Integer id) {
		Skill skill = this.skillRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Skill", "Id", id));
		this.skillRepo.delete(skill);

	}
	
	public Skill dtoToSkill(SkillDto skillDto) {
		Skill skill = this.modelMapper.map(skillDto, Skill.class);
		return skill;
	}

	public SkillDto skillToDto(Skill skill) {
		SkillDto skillDto = this.modelMapper.map(skill, SkillDto.class);
		return skillDto;

	}

}
