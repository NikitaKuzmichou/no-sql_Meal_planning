package com.knv.dto.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recommendation")
@Getter @Setter @Accessors(chain = true)
@FieldNameConstants
public class RecommendationEntity {

    public static final long PROTEINS = 0;
    public static final long FATS = 1;
    public static final long CARBOHYDRATES = 2;
    public static final long CALORIES = 3;

    private ObjectId id = ObjectId.get();
    private String name;
    private long type;
    private double value;
    private String description;
}
