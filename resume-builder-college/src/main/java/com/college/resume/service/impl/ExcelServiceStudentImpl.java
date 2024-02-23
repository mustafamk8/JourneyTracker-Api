package com.college.resume.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.college.resume.entity.StudentPersonel;
import com.college.resume.helper.ExcelHelperStudents;
import com.college.resume.payloads.StudentPersonelDto;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.ExcelServiceStudent;

@Service
public class ExcelServiceStudentImpl implements ExcelServiceStudent {

	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<StudentPersonelDto> createAllStudent(MultipartFile file) {
		// TODO Auto-generated method stub
		List<StudentPersonel> studentBasicDetailsList = null;
		List<StudentPersonelDto> studentDto = null;
		try {
            studentBasicDetailsList = ExcelHelperStudents.convertExcelToListOfStudents(file.getInputStream());
           List<StudentPersonel> list =  this.studentPersonelRepo.saveAll(studentBasicDetailsList);
            studentDto = list.stream().map(st->this.studentToDto(st)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return studentDto;
	}

	public StudentPersonel dtoToStudent(StudentPersonelDto studentPersonelDto) {

		StudentPersonel st = this.modelMapper.map(studentPersonelDto, StudentPersonel.class);
		return st;
	}

	public StudentPersonelDto studentToDto(StudentPersonel studentPersonel) {

		StudentPersonelDto studentPersonelDto = this.modelMapper.map(studentPersonel, StudentPersonelDto.class);
		return studentPersonelDto;

	}
	
}
