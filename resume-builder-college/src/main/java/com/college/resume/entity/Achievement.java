package com.college.resume.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Achievement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private StudentPersonel scholarNo;
	private String achieve;
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
	public String getAchieve() {
		return achieve;
	}
	public void setAchieve(String achieve) {
		this.achieve = achieve;
	}

	
	
	
}
