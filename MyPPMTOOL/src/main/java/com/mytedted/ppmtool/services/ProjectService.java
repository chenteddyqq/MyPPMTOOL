package com.mytedted.ppmtool.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytedted.ppmtool.domain.Project;
import com.mytedted.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Optional<Project> getProjectnyId(Long projectId) {
		return projectRepository.findById(projectId);
	}
}
