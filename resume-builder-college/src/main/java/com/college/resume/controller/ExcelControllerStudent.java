package com.college.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.college.resume.entity.StudentPersonel;
import com.college.resume.helper.ExcelHelperStudents;
import com.college.resume.payloads.StudentPersonelDto;
import com.college.resume.service.ExcelServiceStudent;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ExcelControllerStudent {
    @Autowired
    private ExcelServiceStudent excelServiceStudent;

    @PostMapping("/admin/uploadStudentExcel")
    public ResponseEntity<List<StudentPersonelDto>> upload(@RequestParam("file") MultipartFile file) {
    	List<StudentPersonelDto> studentList = null;
    	
    	if (ExcelHelperStudents.checkExcelFormat(file)) {
            studentList =  this.excelServiceStudent.createAllStudent(file);
        } else {
           System.out.println("something wrong");
        }
        return new ResponseEntity<List<StudentPersonelDto>>(studentList,HttpStatus.CREATED);
    }

    
}

