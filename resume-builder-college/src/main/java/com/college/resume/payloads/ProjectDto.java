package com.college.resume.payloads;



public class ProjectDto {

	private Integer id;
	private StudentPersonelDto scholarNo;
	private String projectName;
	private String projectDesc;
	private String role;
	private Integer duration;
	private String projectLink;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getProjectLink() {
		return projectLink;
	}
	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}
	public ProjectDto() {
		// TODO Auto-generated constructor stub
	}
	
	

}
