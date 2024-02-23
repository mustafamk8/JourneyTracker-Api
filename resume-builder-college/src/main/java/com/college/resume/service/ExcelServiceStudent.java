package com.college.resume.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.college.resume.payloads.StudentPersonelDto;

public interface ExcelServiceStudent {

	public List<StudentPersonelDto> createAllStudent(MultipartFile file);
	
}
