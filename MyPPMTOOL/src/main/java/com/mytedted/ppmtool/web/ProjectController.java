package com.mytedted.ppmtool.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mytedted.ppmtool.domain.Project;
import com.mytedted.ppmtool.services.MapValidationErrorService;
import com.mytedted.ppmtool.services.ProjectService;


@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private MapValidationErrorService errorService;
	
	@GetMapping(path="/api/project/{projectId}")
	public Project retrieveProject(@PathVariable Long projectId){
		return projectService.getProjectnyId(projectId).get();
	}
	
	@PostMapping(path="/api/project")
	public ResponseEntity<?> addQuestionsForSurvey( @Valid @RequestBody Project project, BindingResult bindResult){
		ResponseEntity<?> mapError = errorService.mapValidationErrorService(bindResult);
		if(mapError!=null) return mapError;
		
		Project p1 = projectService.saveOrUpdateProject(project);
		//if (p1 == null) return ResponseEntity.noContent().build();
		return new ResponseEntity<Project>(p1,HttpStatus.CREATED);
		
	}
}
