package com.college.resume.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.college.resume.payloads.StudentPersonelDto;

public interface StudentPersonelService {
	
	public StudentPersonelDto updateStudent(StudentPersonelDto studentPersonelDto,String scholarNo);
	public StudentPersonelDto getStudentById(String scholarNo);
	public List<StudentPersonelDto> getAllStudents();
	public void deleteStudent(String scholarNo);
	public StudentPersonelDto updateImage(String scholarNo, MultipartFile file);
      
	

}
