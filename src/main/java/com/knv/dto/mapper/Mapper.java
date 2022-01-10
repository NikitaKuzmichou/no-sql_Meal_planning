package com.knv.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<ENTITY, MODEL> {

    ENTITY toEntity(MODEL dto);

    MODEL toModel(ENTITY entity);

    default List<ENTITY> toEntity(List<MODEL> models) {
        return models.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default List<MODEL> toModel(final List<ENTITY> entities) {
        return entities.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
