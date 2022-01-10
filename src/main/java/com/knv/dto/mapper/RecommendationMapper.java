package com.knv.dto.mapper;

import com.knv.dto.entity.RecommendationEntity;
import com.knv.dto.model.RecommendationModel;

import java.util.Optional;

public class RecommendationMapper implements Mapper<RecommendationEntity, RecommendationModel> {

    @Override
    public RecommendationEntity toEntity(final RecommendationModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new RecommendationEntity()
                        .setId(model.getId())
                        .setDescription(model.getDescription())
                        .setName(model.getName())
                        .setType(model.getType())
                        .setValue(model.getValue()))
                .orElse(null);
    }

    @Override
    public RecommendationModel toModel(final RecommendationEntity productEntity) {
        return new RecommendationModel()
                .setId(productEntity.getId())
                .setDescription(productEntity.getDescription())
                .setName(productEntity.getName())
                .setType(productEntity.getType())
                .setValue(productEntity.getValue());
    }
}
