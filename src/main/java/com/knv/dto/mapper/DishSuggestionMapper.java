package com.knv.dto.mapper;

import com.knv.dto.entity.DishSuggestionEntity;
import com.knv.dto.model.DishSuggestionModel;

import java.util.Optional;

public class DishSuggestionMapper implements Mapper<DishSuggestionEntity, DishSuggestionModel> {

    @Override
    public DishSuggestionEntity toEntity(final DishSuggestionModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new DishSuggestionEntity()
                        .setDish(Mappers.DISH_MAPPER.toEntity(dto.getDish()))
                        .setDishId(dto.getDishId())
                        .setDate(dto.getDate())
                        .setUser(Mappers.USER_MAPPER.toEntity(dto.getUser()))
                        .setUserId(dto.getUserId()))
                .orElse(null);
    }

    @Override
    public DishSuggestionModel toModel(final DishSuggestionEntity entity) {
        return new DishSuggestionModel()
                .setDish(Mappers.DISH_MAPPER.toModel(entity.getDish()))
                .setDishId(entity.getDishId())
                .setDate(entity.getDate())
                .setUser(Mappers.USER_MAPPER.toModel(entity.getUser()))
                .setUserId(entity.getUserId());
    }
}
