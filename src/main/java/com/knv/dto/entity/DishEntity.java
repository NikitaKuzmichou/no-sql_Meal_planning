package com.knv.dto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "dish")
@Getter @Setter @Accessors(chain = true)
@FieldNameConstants
public class DishEntity {

    private ObjectId id = ObjectId.get();
    private String name;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;
    private Double calories;
    private List<ProductEntity> products;
}
