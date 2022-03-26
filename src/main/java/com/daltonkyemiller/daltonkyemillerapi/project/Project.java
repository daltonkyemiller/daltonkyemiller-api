package com.daltonkyemiller.daltonkyemillerapi.project;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document

public class Project {
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private String projectName;

    @NotNull
    private String projectDesc;

    @NotNull
    private List<ProjectPhoto> projectPhotos;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    public Project(String projectName,
                   String projectDesc,
                   List<ProjectPhoto> projectPhotos,
                   LocalDateTime created,
                   LocalDateTime modified)  {
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectPhotos = projectPhotos;
        this.created = created;
        this.modified = modified;
    }
}
