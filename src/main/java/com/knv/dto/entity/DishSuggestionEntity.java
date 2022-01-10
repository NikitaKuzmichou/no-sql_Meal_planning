package com.knv.dto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "dish_suggestion")
@Getter @Setter @Accessors(chain = true)
@FieldNameConstants
public class DishSuggestionEntity {

    private ObjectId id = ObjectId.get();

    @BsonProperty(value = "user_id")
    private ObjectId userId;

    @BsonProperty(value = "dish_id")
    private ObjectId dishId;
    private LocalDate date;
    private DishEntity dish;
    private UserEntity user;
}
