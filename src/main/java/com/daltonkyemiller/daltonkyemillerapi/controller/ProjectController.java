package com.daltonkyemiller.daltonkyemillerapi.controller;


import com.daltonkyemiller.daltonkyemillerapi.model.Project;
import com.daltonkyemiller.daltonkyemillerapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController  {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> fetchAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("{nameOrId}")
    public Optional<Project> fetchProjectByName(@PathVariable("nameOrId") String nameOrId){
        return projectService.getProjectByNameOrId(nameOrId);
    }

    @PostMapping("add")
    public void uploadProject(@Validated @RequestBody Project project){
        projectService.addProject(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") String id){
        projectService.deleteProjectById(id);

    }

}
