package com.knv.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import java.util.List;

@Getter @Setter @Accessors(chain = true)
public class DishModel {

    private ObjectId id;
    private String name;
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;
    private List<ProductModel> products;
}
