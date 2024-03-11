package com.college.resume.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.resume.entity.AcademicDetails;
import com.college.resume.entity.Career;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.payloads.AcademicDetailsDto;
import com.college.resume.payloads.CareerDto;
import com.college.resume.repository.AcademicDetailsRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.AcademicDetailsService;

@Service
public class AcademicDetailsServiceImpl implements AcademicDetailsService {

	@Autowired
	private AcademicDetailsRepo academicsDetailsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	
	@Override
	public AcademicDetailsDto createAcademic(AcademicDetailsDto academicDetailsDto, String scholarNo) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholarNo).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
		AcademicDetails academic1 = this.dtoToAcademic(academicDetailsDto);
		academic1.setScholarNo(student);
		AcademicDetails newAcademic = this.academicsDetailsRepo.save(academic1);
		return this.academicToDto(newAcademic);
	}

	@Override
	public AcademicDetailsDto updateAcademic(AcademicDetailsDto academicDetailsDto, Integer cid) {
		AcademicDetails academic = this.academicsDetailsRepo.findById(cid).orElseThrow(()->new ResourceNotFoundExceptionAll("Academic details", "Id", cid));
		academic.setTenthBoard(academicDetailsDto.getTenthBoard());
		academic.setTenthSchoolName(academicDetailsDto.getTenthSchoolName());
		academic.setTenthNumber(academicDetailsDto.getTenthNumber());
		academic.setTwelfthBoard(academicDetailsDto.getTwelfthBoard());
		academic.setTwelfthSchoolName(academicDetailsDto.getTwelfthSchoolName());
		academic.setTwelfthNumber(academicDetailsDto.getTwelfthNumber());
		academic.setCollegeBacklog(academicDetailsDto.getCollegeBacklog());
		academic.setCollegeCgpa(academicDetailsDto.getCollegeCgpa());
		AcademicDetails updatedAcademic = this.academicsDetailsRepo.save(academic);
		
		return this.academicToDto(updatedAcademic);
	}

	@Override
	public AcademicDetailsDto getAcademicById(Integer cid) {
		AcademicDetails academic = this.academicsDetailsRepo.findById(cid).orElseThrow(()->new ResourceNotFoundExceptionAll("Academic details", "Id", cid));
		
		return this.academicToDto(academic);
	}

	@Override
	public AcademicDetailsDto getAcademicByScholar(String scholarNo) {
		// TODO Auto-generated method stub
		StudentPersonel st = this.studentPersonelRepo.findById(scholarNo).orElseThrow(()->new ResourceNotFoundException("AcademicDetails", "Id", scholarNo));
		AcademicDetails academic = this.academicsDetailsRepo.findByScholarNo(st);
		return this.academicToDto(academic);
	}
	
	public AcademicDetails dtoToAcademic(AcademicDetailsDto academicDetailsDto) {

		AcademicDetails academicDetails = this.modelMapper.map(academicDetailsDto, AcademicDetails.class);
		return academicDetails;
	}

	public AcademicDetailsDto academicToDto(AcademicDetails academicDetails) {

		AcademicDetailsDto academicDetailsDto = this.modelMapper.map(academicDetails, AcademicDetailsDto.class);
		return academicDetailsDto;

	}

	
	
}
