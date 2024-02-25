package com.college.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.resume.payloads.AchievementDto;
import com.college.resume.payloads.ApiResponse;
import com.college.resume.service.AchievementService;


@RestController
@RequestMapping("/resume/achievement")
public class AchievementController {

	@Autowired
	private AchievementService achievementService;
	
	@PostMapping("/scholar/{scholarId}")
	public ResponseEntity<AchievementDto> createAchievement(@RequestBody AchievementDto achievementDto,@PathVariable("scholarId") String scholarId){
		
		AchievementDto achieve = this.achievementService.createAchievement(achievementDto, scholarId);
		
		return new ResponseEntity<AchievementDto>(achieve,HttpStatus.CREATED);
	}
	
	@PutMapping("/achieve/{achieveId}")
	public ResponseEntity<AchievementDto> updateAchievement(@RequestBody AchievementDto achievementDto,@PathVariable("achieveId") Integer achieveId){
		AchievementDto achieve = this.achievementService.updateAchievement(achievementDto, achieveId);
		return new ResponseEntity<AchievementDto>(achieve,HttpStatus.OK);
	}
	
	@DeleteMapping("/achieve/{achieveId}")
	public  ApiResponse deleteAchievement(@PathVariable("achieveId") Integer achieveId){
		this.achievementService.deleteAchievement(achieveId);
		return new ApiResponse("Achievement deleted successfully",true);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AchievementDto>> getAllAchieve(){
		List<AchievementDto> allAchieve = this.achievementService.getAllAchievement();
		return new ResponseEntity<List<AchievementDto>>(allAchieve,HttpStatus.OK);
	}
	
	@GetMapping("/scholarId/{scholarId}")
	public ResponseEntity<List<AchievementDto>> getAllAchieveByScholar(@PathVariable("scholarId") String scholarId){
		List<AchievementDto> allAchieveByScholar = this.achievementService.getAchievementByScholar(scholarId);
		return new ResponseEntity<List<AchievementDto>>(allAchieveByScholar,HttpStatus.OK);
	}
	
	
}
