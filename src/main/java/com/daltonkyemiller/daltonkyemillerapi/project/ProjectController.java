package com.daltonkyemiller.daltonkyemillerapi.project;


import com.daltonkyemiller.daltonkyemillerapi.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/projects")
public class ProjectController  {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> fetchAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @GetMapping("{nameOrId}")
    public ResponseEntity<Project> fetchProjectByName(@PathVariable("nameOrId") String nameOrId){
        return ResponseEntity.ok().body(projectService.getProjectByNameOrId(nameOrId));
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('project:write')")
    public void uploadProject(@Validated @RequestBody Project project){
        projectService.addProject(project);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('project:write')")
    public void deleteProject(@PathVariable("id") String id){
        projectService.deleteProjectById(id);

    }

}
