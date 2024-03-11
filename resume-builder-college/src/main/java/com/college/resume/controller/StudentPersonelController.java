package com.college.resume.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.resume.payloads.ApiResponse;
import com.college.resume.payloads.StudentPersonelDto;
import com.college.resume.service.StudentPersonelService;

@RestController
@RequestMapping("resume")
public class StudentPersonelController {
	
	@Autowired
	private StudentPersonelService studentPersonelService;
	
	@PutMapping("/update/{scholarNo}")
	public ResponseEntity<StudentPersonelDto> updateStudent(@RequestBody StudentPersonelDto studentPersonelDto, @PathVariable("scholarNo") String scholarNo){
		
		StudentPersonelDto updatedStudent = this.studentPersonelService.updateStudent(studentPersonelDto, scholarNo);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/delete/{scholarNo}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("scholarNo") String scholarNo){
		this.studentPersonelService.deleteStudent(scholarNo);
		return new ResponseEntity<ApiResponse>(new ApiResponse("student deleted successfully",true),HttpStatus.OK);
	
	}
	
	@GetMapping("/studentId/{scholarNo}")
	public ResponseEntity<StudentPersonelDto> getStudentByScholar(@PathVariable("scholarNo") String scholarNo){
		StudentPersonelDto student = this.studentPersonelService.getStudentById(scholarNo);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/allStudent")
	public ResponseEntity<List<StudentPersonelDto>> getAllStudent(){
		return ResponseEntity.ok(this.studentPersonelService.getAllStudents());
	}
	
	@PutMapping("/image/{scholarNo}")
	public ResponseEntity<StudentPersonelDto> updateImage(@PathVariable("scholarNo") String scholarNo, @RequestParam("file") MultipartFile file) throws IOException {
        
		StudentPersonelDto st = this.studentPersonelService.updateImage(scholarNo, file);
		
       return  ResponseEntity.ok(st);
    }
	
	

}
