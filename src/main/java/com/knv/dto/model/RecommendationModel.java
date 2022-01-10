package com.knv.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

@Getter @Setter @Accessors(chain = true)
public class RecommendationModel {
    private ObjectId id;
    private String name;
    private long type;
    private double value;
    private String description;
}
