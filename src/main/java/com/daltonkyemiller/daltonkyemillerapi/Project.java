package com.daltonkyemiller.daltonkyemillerapi;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Project {
    @Id
    private String id;
    @Indexed(unique = true)
    private String projectName;
    private String projectDesc;
    private List<ProjectPhoto> projectPhotos;
    private LocalDateTime created;

    public Project(String projectName,
                   String projectDesc,
                   List<ProjectPhoto> projectPhotos,
                   LocalDateTime created)  {
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectPhotos = projectPhotos;
        this.created = created;
    }
}
