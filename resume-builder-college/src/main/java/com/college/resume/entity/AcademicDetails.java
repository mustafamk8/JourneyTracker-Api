package com.college.resume.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AcademicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private StudentPersonel scholarNo;
	
	private String tenthSchoolName;
	
	private String tenthBoard;
	
	private Double tenthNumber;
	
	private String twelfthSchoolName;
	
	private String twelfthBoard;
	
	private Double twelfthNumber;
	
	private String collegeBacklog;
	
	private Double collegeCgpa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentPersonel getScholarNo() {
		return scholarNo;
	}

	public void setScholarNo(StudentPersonel scholarNo) {
		this.scholarNo = scholarNo;
	}

	public String getTenthSchoolName() {
		return tenthSchoolName;
	}

	public void setTenthSchoolName(String tenthSchoolName) {
		this.tenthSchoolName = tenthSchoolName;
	}

	public String getTenthBoard() {
		return tenthBoard;
	}

	public void setTenthBoard(String tenthBoard) {
		this.tenthBoard = tenthBoard;
	}

	public Double getTenthNumber() {
		return tenthNumber;
	}

	public void setTenthNumber(Double tenthNumber) {
		this.tenthNumber = tenthNumber;
	}

	public String getTwelfthSchoolName() {
		return twelfthSchoolName;
	}

	public void setTwelfthSchoolName(String twelfthSchoolName) {
		this.twelfthSchoolName = twelfthSchoolName;
	}

	public String getTwelfthBoard() {
		return twelfthBoard;
	}

	public void setTwelfthBoard(String twelfthBoard) {
		this.twelfthBoard = twelfthBoard;
	}

	public Double getTwelfthNumber() {
		return twelfthNumber;
	}

	public void setTwelfthNumber(Double twelfthNumber) {
		this.twelfthNumber = twelfthNumber;
	}

	public String getCollegeBacklog() {
		return collegeBacklog;
	}

	public void setCollegeBacklog(String collegeBacklog) {
		this.collegeBacklog = collegeBacklog;
	}

	public Double getCollegeCgpa() {
		return collegeCgpa;
	}

	public void setCollegeCgpa(Double collegeCgpa) {
		this.collegeCgpa = collegeCgpa;
	}

	public AcademicDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
}
