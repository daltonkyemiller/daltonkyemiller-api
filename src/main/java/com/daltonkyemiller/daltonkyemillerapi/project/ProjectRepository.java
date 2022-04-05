package com.daltonkyemiller.daltonkyemillerapi.project;

import com.daltonkyemiller.daltonkyemillerapi.project.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {
    Optional<Project> findProjectByProjectNameEquals(String projectName);
    Optional<Project> findProjectByProjectNameOrIdEquals(String projectName, String id);
    Optional<Project> deleteProjectByIdEquals(String id);

}
