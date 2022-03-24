package com.daltonkyemiller.daltonkyemillerapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {
    Optional<Project> findProjectByProjectNameEquals(String projectName);
}
