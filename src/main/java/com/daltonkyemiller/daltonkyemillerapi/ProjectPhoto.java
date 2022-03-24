package com.daltonkyemiller.daltonkyemillerapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ProjectPhoto {
    private String photoName;
    private String photoDesc;
    private Dimensions dimensions;
}
