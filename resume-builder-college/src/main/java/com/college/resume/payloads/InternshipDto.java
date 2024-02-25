package com.college.resume.payloads;

import java.util.Date;


public class InternshipDto {

	private Integer id;
	private StudentPersonelDto scholarNo;
	private String trName;
	private String orgName;
	private Date trStartDate;
	private Date trEndDate;
	private String certiUrl;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StudentPersonelDto getScholarNo() {
		return scholarNo;
	}
	public void setScholarNo(StudentPersonelDto scholarNo) {
		this.scholarNo = scholarNo;
	}
	public String getTrName() {
		return trName;
	}
	public void setTrName(String trName) {
		this.trName = trName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Date getTrStartDate() {
		return trStartDate;
	}
	public void setTrStartDate(Date trStartDate) {
		this.trStartDate = trStartDate;
	}
	public Date getTrEndDate() {
		return trEndDate;
	}
	public void setTrEndDate(Date trEndDate) {
		this.trEndDate = trEndDate;
	}
	public String getCertiUrl() {
		return certiUrl;
	}
	public void setCertiUrl(String certiUrl) {
		this.certiUrl = certiUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public InternshipDto() {
		// TODO Auto-generated constructor stub
	}
	
	

}
