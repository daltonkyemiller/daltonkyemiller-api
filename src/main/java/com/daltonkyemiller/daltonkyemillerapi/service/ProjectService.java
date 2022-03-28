package com.daltonkyemiller.daltonkyemillerapi.service;

import com.daltonkyemiller.daltonkyemillerapi.dao.ProjectRepository;
import com.daltonkyemiller.daltonkyemillerapi.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectByNameOrId(String nameOrId){
        Optional<Project> project = projectRepository.findProjectByProjectNameOrIdEquals(nameOrId, nameOrId);
        if(!project.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }
        return project;
    }

    public Optional<Project> deleteProjectById(String id){
        return projectRepository.deleteProjectByIdEquals(id);
    }

    public void addProject(Project project){
        // Check if project exists in database
        Optional<Project> projectOptional = projectRepository.findProjectByProjectNameEquals(project.getProjectName());
        if(projectOptional.isPresent()){
            throw new IllegalStateException("Project already exists, try updating project instead.");
        }
        projectRepository.save(project);
    }
}
