package com.daltonkyemiller.daltonkyemillerapi.project;


import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/projects")
@AllArgsConstructor
public class ProjectController  {
    private final ProjectService projectService;

    @GetMapping
    public List<Project> fetchAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("{name}")
    public Optional<Project> fetchProjectByName(@PathVariable("name") String name){
        return projectService.getProjectByName(name);
    }

    @PostMapping("add")
    public void uploadProject(@Validated @RequestBody Project project){
        projectService.addProject(project);
    }

}
