package com.college.resume.service;

import com.college.resume.payloads.CareerDto;

public interface CareerService {

	CareerDto createCareer(CareerDto careerDto,String scholarNo);
	CareerDto updateCareer(CareerDto careerDto, Integer cid);
	CareerDto getCareerById(Integer cid);
	CareerDto getCareerByScholar(String scholarNo);
	
}
