package com.knv.dto.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Mappers {

    public static final DishMapper DISH_MAPPER = new DishMapper();
    public static final DishSuggestionMapper DISH_SUGGESTION_MAPPER = new DishSuggestionMapper();
    public static final ProductMapper PRODUCT_MAPPER = new ProductMapper();
    public static final RationMapper RATION_MAPPER = new RationMapper();
    public static final RecommendationMapper RECOMMENDATION_MAPPER = new RecommendationMapper();
    public static final UserMapper USER_MAPPER = new UserMapper();
}
