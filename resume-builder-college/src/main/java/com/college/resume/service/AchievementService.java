package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.AchievementDto;

public interface AchievementService {
	
	AchievementDto createAchievement(AchievementDto achievementDto, String scholarNo);
	AchievementDto updateAchievement(AchievementDto achievementDto, Integer id);
	List<AchievementDto> getAchievementByScholar(String scholar);
	List<AchievementDto> getAllAchievement();
	void deleteAchievement(Integer id);

}
