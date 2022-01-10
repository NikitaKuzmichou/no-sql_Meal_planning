package com.knv.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @Accessors(chain = true)
public class RationModel {
    private ObjectId id;
    private ObjectId userId;
    private LocalDate date;
    private List<RecommendationModel> recommendations;
    private List<DishModel> dishes;
    private UserModel user;
}
