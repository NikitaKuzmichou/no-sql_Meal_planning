package com.knv.dto.mapper;

import com.knv.dto.entity.RationEntity;
import com.knv.dto.model.RationModel;

import java.util.Optional;

public class RationMapper implements Mapper<RationEntity, RationModel> {

    @Override
    public RationEntity toEntity(final RationModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new RationEntity()
                        .setId(dto.getId())
                        .setDate(dto.getDate())
                        .setUserId(dto.getUserId())
                        .setUser(Mappers.USER_MAPPER.toEntity(dto.getUser()))
                        .setDishes(Mappers.DISH_MAPPER.toEntity(dto.getDishes()))
                        .setRecommendations(Mappers.RECOMMENDATION_MAPPER.toEntity(dto.getRecommendations())))
                .orElse(null);
    }

    @Override
    public RationModel toModel(final RationEntity entity) {
        return new RationModel()
                .setId(entity.getId())
                .setDate(entity.getDate())
                .setUserId(entity.getUserId())
                .setUser(Mappers.USER_MAPPER.toModel(entity.getUser()))
                .setDishes(Mappers.DISH_MAPPER.toModel(entity.getDishes()))
                .setRecommendations(Mappers.RECOMMENDATION_MAPPER.toModel(entity.getRecommendations()));
    }
}
