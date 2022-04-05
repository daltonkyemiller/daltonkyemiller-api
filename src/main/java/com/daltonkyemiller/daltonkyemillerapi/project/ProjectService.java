package com.daltonkyemiller.daltonkyemillerapi.project;

import com.daltonkyemiller.daltonkyemillerapi.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return projectRepository.findProjectByProjectNameOrIdEquals(nameOrId, nameOrId);
    }

    public Optional<Project> deleteProjectById(String id){
        return projectRepository.deleteProjectByIdEquals(id);
    }

    public void addProject(Project project){
        projectRepository.save(project);
    }
}
