package com.college.resume.service;

import com.college.resume.payloads.AcademicDetailsDto;

public interface AcademicDetailsService {

	AcademicDetailsDto createAcademic(AcademicDetailsDto academicDetailsDto,String scholarNo);
	AcademicDetailsDto updateAcademic(AcademicDetailsDto academicDetailsDto, Integer cid);
	AcademicDetailsDto getAcademicById(Integer cid);
	AcademicDetailsDto getAcademicByScholar(String scholarNo);
	
}
