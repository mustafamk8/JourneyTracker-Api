package com.college.resume.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.resume.entity.Project;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.payloads.ProjectDto;
import com.college.resume.repository.ProjectRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Override
	public ProjectDto createProject(ProjectDto projectDto, String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		Project project = this.dtoToProject(projectDto);
		project.setScholarNo(student);
		Project savedProject = this.projectRepo.save(project);
		return this.projectToDto(savedProject);
	}

	@Override
	public ProjectDto updateProject(ProjectDto projectDto, Integer id) {
		Project project = this.projectRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Project", "Id", id));
		project.setProjectName(projectDto.getProjectName());
		project.setProjectDesc(projectDto.getProjectDesc());
		project.setProjectLink(projectDto.getProjectLink());
		project.setRole(projectDto.getRole());
		project.setDuration(projectDto.getDuration());
		
		Project updateProject = this.projectRepo.save(project);
		return this.projectToDto(updateProject);
	}

	@Override
	public List<ProjectDto> getProjectByScholar(String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		List<Project> projectList = this.projectRepo.findByScholarNo(student);
		List<ProjectDto> list = projectList.stream().map(project -> this.projectToDto(project))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<ProjectDto> getAllProject() {
		List<Project> projectList = this.projectRepo.findAll();
		List<ProjectDto> list = projectList.stream().map(project -> this.projectToDto(project))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteProject(Integer id) {
		Project project = this.projectRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Project", "Id", id));
		this.projectRepo.delete(project);
	}
	
	public Project dtoToProject(ProjectDto projectDto) {
		Project project = this.modelMapper.map(projectDto, Project.class);
		return project;
	}

	public ProjectDto projectToDto(Project project) {
		ProjectDto projectDto = this.modelMapper.map(project, ProjectDto.class);
		return projectDto;

	}
	
	

}
