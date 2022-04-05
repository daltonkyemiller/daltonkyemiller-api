package com.daltonkyemiller.daltonkyemillerapi.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectPhoto {
    private String photoName;
    private String photoDesc;
    private Dimensions dimensions;
}
