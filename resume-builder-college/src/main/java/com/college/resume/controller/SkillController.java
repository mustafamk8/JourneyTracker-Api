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
import com.college.resume.payloads.ApiResponse;
import com.college.resume.payloads.SkillDto;
import com.college.resume.service.SkillService;

@RestController
@RequestMapping("/resume/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@PostMapping("/scholar/{scholarId}")
	public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto,
			@PathVariable("scholarId") String scholarId) {

		SkillDto skill = this.skillService.createSkill(skillDto, scholarId);

		return new ResponseEntity<SkillDto>(skill, HttpStatus.CREATED);
	}

	@PutMapping("/skillId/{skillId}")
	public ResponseEntity<SkillDto> updateSkill(@RequestBody SkillDto skillDto,
			@PathVariable("skillId") Integer skillId) {
		SkillDto skill = this.skillService.updateSkill(skillDto, skillId);
		return new ResponseEntity<SkillDto>(skill, HttpStatus.OK);
	}

	@DeleteMapping("/skillId/{skillId}")
	public ApiResponse deleteSkill(@PathVariable("skillId") Integer skillId) {
		this.skillService.deleteSkill(skillId);
		return new ApiResponse("Skill deleted successfully", true);
	}

	@GetMapping("/")
	public ResponseEntity<List<SkillDto>> getAllSkill() {
		List<SkillDto> allSkill = this.skillService.getAllSkill();
		return new ResponseEntity<List<SkillDto>>(allSkill, HttpStatus.OK);
	}

	@GetMapping("/scholarId/{scholarId}")
	public ResponseEntity<List<SkillDto>> getAllSkillByScholar(@PathVariable("scholarId") String scholarId) {
		List<SkillDto> allSkillByScholar = this.skillService.getSkillByScholar(scholarId);
		return new ResponseEntity<List<SkillDto>>(allSkillByScholar, HttpStatus.OK);
	}
	
	
}
