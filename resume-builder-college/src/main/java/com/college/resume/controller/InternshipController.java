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
import com.college.resume.payloads.InternshipDto;
import com.college.resume.service.InternshipService;

@RestController
@RequestMapping("resume/internship")
public class InternshipController {
	
	@Autowired
	private InternshipService internshipService;
	
	@PostMapping("/scholar/{scholar}")
	public ResponseEntity<InternshipDto> createInternship(@RequestBody InternshipDto internshipDto,@PathVariable("scholar") String scholar){
		InternshipDto intern = this.internshipService.createInternship(internshipDto, scholar);
		return new ResponseEntity<InternshipDto>(intern,HttpStatus.CREATED);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<InternshipDto> updateInternship(@RequestBody InternshipDto internshipDto, @PathVariable("id") Integer id){
		InternshipDto updatedIntern = this.internshipService.updateInternship(internshipDto, id);
		return new ResponseEntity<InternshipDto>(updatedIntern,HttpStatus.OK);
	}
	
	@GetMapping("/scholar/{scholarId}")
	public ResponseEntity<List<InternshipDto>> getInternByScholar(@PathVariable("scholarId") String scholarId){
		List<InternshipDto> list = this.internshipService.getInternshipByScholar(scholarId);
		return new ResponseEntity<List<InternshipDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<InternshipDto>> getAllInternship(){
		List<InternshipDto> list = this.internshipService.getAllInternship();
		return new ResponseEntity<List<InternshipDto>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ApiResponse deleteInternship(@PathVariable("id") Integer id) {
		this.internshipService.deleteInternship(id);
		return new ApiResponse("Internship deleted successfully",true);
	}
	
}
