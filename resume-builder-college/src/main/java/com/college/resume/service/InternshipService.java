package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.InternshipDto;

public interface InternshipService {

	InternshipDto createInternship(InternshipDto internshipDto, String scholar);
	
	InternshipDto updateInternship(InternshipDto internshipDto, Integer id);
	
	List<InternshipDto> getInternshipByScholar(String scholar);
	
	List<InternshipDto> getAllInternship();
	
	void deleteInternship(Integer id);
	
}
