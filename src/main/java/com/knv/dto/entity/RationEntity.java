package com.knv.dto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "ration")
@Getter @Setter @Accessors(chain = true)
@FieldNameConstants
public class RationEntity {

    private ObjectId id = ObjectId.get();

    @BsonProperty(value = "user_id")
    private ObjectId userId;
    private LocalDate date;
    private List<RecommendationEntity> recommendations;
    private List<DishEntity> dishes;
    private UserEntity user;
}
