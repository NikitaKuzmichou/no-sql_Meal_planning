package com.knv.dto.mapper;

import com.knv.dto.entity.DishEntity;
import com.knv.dto.model.DishModel;

import java.util.Optional;

public class DishMapper implements Mapper<DishEntity, DishModel> {

    @Override
    public DishEntity toEntity(final DishModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new DishEntity()
                        .setCarbohydrates(dto.getCarbohydrates())
                        .setCalories(dto.getCalories())
                        .setProteins(dto.getProteins())
                        .setFats(dto.getFats())
                        .setName(dto.getName())
                        .setProducts(Mappers.PRODUCT_MAPPER.toEntity(dto.getProducts())))
                .orElse(null);
    }

    @Override
    public DishModel toModel(final DishEntity entity) {
        return new DishModel()
                .setId(entity.getId())
                .setCarbohydrates(entity.getCarbohydrates())
                .setCalories(entity.getCalories())
                .setProteins(entity.getProteins())
                .setFats(entity.getFats())
                .setName(entity.getName())
                .setProducts(Mappers.PRODUCT_MAPPER.toModel(entity.getProducts()));
    }
}
