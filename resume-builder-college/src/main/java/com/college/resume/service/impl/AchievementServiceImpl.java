package com.college.resume.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.resume.entity.Achievement;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.payloads.AchievementDto;
import com.college.resume.repository.AchievementRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.AchievementService;

@Service
public class AchievementServiceImpl implements AchievementService{

	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private AchievementRepo achievementRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AchievementDto createAchievement(AchievementDto achievementDto, String scholarNo) {
		
		StudentPersonel student = this.studentPersonelRepo.findById(scholarNo).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
		Achievement achieve = this.dtoToAchievement(achievementDto);
		achieve.setScholarNo(student);
		Achievement savedAchieve = this.achievementRepo.save(achieve);
		return this.achievementToDto(savedAchieve);
	}

	@Override
	public AchievementDto updateAchievement(AchievementDto achievementDto, Integer id) {
		
		Achievement achieve = this.achievementRepo.findById(id).orElseThrow(()->new ResourceNotFoundExceptionAll("Achievement", "Id", id));
		achieve.setAchieve(achievementDto.getAchieve());
		Achievement updatedAchieve = this.achievementRepo.save(achieve);
		return this.achievementToDto(updatedAchieve);
	}

	@Override
	public List<AchievementDto> getAchievementByScholar(String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		List<Achievement> achieveList = this.achievementRepo.findByScholarNo(student);
		List<AchievementDto> list = achieveList.stream().map(achieve->this.achievementToDto(achieve)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<AchievementDto> getAllAchievement() {
		List<Achievement> achieve = this.achievementRepo.findAll();
		List<AchievementDto> list = achieve.stream().map(a->this.achievementToDto(a)).collect(Collectors.toList());
		
		return list;
	}

	@Override
	public void deleteAchievement(Integer id) {
		Achievement achieve = this.achievementRepo.findById(id).orElseThrow(()->new ResourceNotFoundExceptionAll("Achievement", "Id", id));
		this.achievementRepo.delete(achieve);
		
	}
	
	public Achievement dtoToAchievement(AchievementDto achieveDto) {
		Achievement achieve = this.modelMapper.map(achieveDto, Achievement.class);
		return achieve;
	}

	public AchievementDto achievementToDto(Achievement achieve) {
		AchievementDto achieveDto = this.modelMapper.map(achieve, AchievementDto.class);
		return achieveDto;

	}
	
	
	
}
