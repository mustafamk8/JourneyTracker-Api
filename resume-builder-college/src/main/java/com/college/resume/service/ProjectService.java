package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.ProjectDto;

public interface ProjectService {

	ProjectDto createProject(ProjectDto skillDto, String scholar);

	ProjectDto updateProject(ProjectDto skillDto, Integer id);

	List<ProjectDto> getProjectByScholar(String scholar);

	List<ProjectDto> getAllProject();

	void deleteProject(Integer id);
	
}
