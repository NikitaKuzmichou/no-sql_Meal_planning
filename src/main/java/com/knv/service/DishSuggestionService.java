package com.knv.service;

import com.knv.dto.entity.DishSuggestionEntity;
import com.knv.repository.DishSuggestionRepository;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DishSuggestionService {

    public static void insert(final MongoDatabase database, final DishSuggestionEntity entity) {
        DishSuggestionRepository.insert(database, entity);
    }
}
