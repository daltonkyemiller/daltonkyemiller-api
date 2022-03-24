package com.daltonkyemiller.daltonkyemillerapi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class  ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectByName(String name){
        return projectRepository.findProjectByProjectNameEquals(name);
    }
}
