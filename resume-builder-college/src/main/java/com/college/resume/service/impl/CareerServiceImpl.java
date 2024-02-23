package com.college.resume.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.resume.entity.Career;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.payloads.CareerDto;
import com.college.resume.repository.CareerRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.CareerService;

@Service
public class CareerServiceImpl implements CareerService {

	@Autowired
	private CareerRepo careerRepo;
	
	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CareerDto createCareer(CareerDto careerDto,String scholarNo) {
		// TODO Auto-generated method stub
		
		StudentPersonel student = this.studentPersonelRepo.findById(scholarNo).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
		Career career = this.dtoToCareer(careerDto);
		career.setScholarNo(student);
		Career newCareer = this.careerRepo.save(career);
		return this.careerToDto(newCareer);
	}

	@Override
	public CareerDto updateCareer(CareerDto careerDto, Integer cid) {
		// TODO Auto-generated method stub 
		Career career = this.careerRepo.findById(cid).orElseThrow(()->new ResourceNotFoundExceptionAll("Carreer", "Id", cid));
		career.setObjective(careerDto.getObjective());
		career.setHobby1(careerDto.getHobby1());
		career.setHobby2(careerDto.getHobby2());
		career.setStrength1(careerDto.getStrength1());
		career.setStrength2(careerDto.getStrength2());
		career.setWeakness1(careerDto.getWeakness1());
		career.setWeakness2(careerDto.getWeakness2());
		
		Career updatedCareer = this.careerRepo.save(career);
		
		return this.careerToDto(updatedCareer);
	}

	@Override
	public CareerDto getCareerById(Integer cid) {
		// TODO Auto-generated method stub
		Career career = this.careerRepo.findById(cid).orElseThrow(()->new ResourceNotFoundExceptionAll("Carreer", "Id", cid));
		
		return this.careerToDto(career);
	}

	@Override
	public CareerDto getCareerByScholar(String scholarNo) {
		// TODO Auto-generated method stub
		StudentPersonel st = this.studentPersonelRepo.findById(scholarNo).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
		Career career = this.careerRepo.findByScholarNo(st);
		return this.careerToDto(career);
	}
	
	public Career dtoToCareer(CareerDto careerDto) {

		Career career = this.modelMapper.map(careerDto, Career.class);
		return career;
	}

	public CareerDto careerToDto(Career career) {

		CareerDto careerDto = this.modelMapper.map(career, CareerDto.class);
		return careerDto;

	}

}
