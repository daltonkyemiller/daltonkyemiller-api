package com.daltonkyemiller.daltonkyemillerapi.project;

import com.daltonkyemiller.daltonkyemillerapi.project.model.Project;
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

    public Project getProjectByNameOrId(String nameOrId) throws ResponseStatusException {
        return projectRepository.findProjectByProjectNameOrIdEquals(nameOrId, nameOrId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Optional<Project> deleteProjectById(String id){
        return projectRepository.deleteProjectByIdEquals(id);
    }

    public void addProject(Project project){
        projectRepository.save(project);
    }
}
