package com.college.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.resume.payloads.AcademicDetailsDto;
import com.college.resume.payloads.CareerDto;
import com.college.resume.service.AcademicDetailsService;

@RestController
@RequestMapping("/academics")
public class AcademicController {

	@Autowired
	private AcademicDetailsService academicDetailsService;
	
	@PostMapping("/{scholarNo}")
	public ResponseEntity<AcademicDetailsDto> createAcademics(@RequestBody AcademicDetailsDto academicDto, @PathVariable("scholarNo")String scholarNo){
		AcademicDetailsDto createdAcademic = this.academicDetailsService.createAcademic(academicDto, scholarNo);
		return new ResponseEntity<AcademicDetailsDto>(createdAcademic,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AcademicDetailsDto> updateAcademic(@RequestBody AcademicDetailsDto academicDto, @PathVariable("id")Integer id){
		AcademicDetailsDto academic = this.academicDetailsService.updateAcademic(academicDto, id);
		return ResponseEntity.ok(academic);
	}
	
	@GetMapping("/academicId/{id}")
	public ResponseEntity<AcademicDetailsDto> getAcademicById(@PathVariable("id")Integer id){
		AcademicDetailsDto academic = this.academicDetailsService.getAcademicById(id);
		return ResponseEntity.ok(academic);
	}
	
	@GetMapping("/scholarId/{scholarNo}")
	public ResponseEntity<AcademicDetailsDto> getAcademicByScholar(@PathVariable("scholarNo")String scholarNo){
		AcademicDetailsDto academic = this.academicDetailsService.getAcademicByScholar(scholarNo);
		return ResponseEntity.ok(academic);
	}
}
