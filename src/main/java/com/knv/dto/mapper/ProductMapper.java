package com.knv.dto.mapper;

import com.knv.dto.entity.ProductEntity;
import com.knv.dto.model.ProductModel;

import java.util.Optional;

public class ProductMapper implements Mapper<ProductEntity, ProductModel> {

    @Override
    public ProductEntity toEntity(final ProductModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new ProductEntity()
                        .setId(dto.getId())
                        .setCalories(dto.getCalories())
                        .setCarbohydrates(dto.getCarbohydrates())
                        .setFats(dto.getFats())
                        .setName(dto.getName())
                        .setProteins(dto.getProteins()))
                .orElse(null);
    }

    @Override
    public ProductModel toModel(final ProductEntity entity) {
        return new ProductModel()
                .setId(entity.getId())
                .setCalories(entity.getCalories())
                .setCarbohydrates(entity.getCarbohydrates())
                .setFats(entity.getFats())
                .setName(entity.getName())
                .setProteins(entity.getProteins());
    }
}
