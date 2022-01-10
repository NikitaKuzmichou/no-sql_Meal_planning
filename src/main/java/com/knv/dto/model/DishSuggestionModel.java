package com.knv.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Getter @Setter @Accessors(chain = true)
public class DishSuggestionModel {

    private ObjectId id;
    private ObjectId userId;
    private ObjectId dishId;
    private LocalDate date;
    private DishModel dish;
    private UserModel user;
}
