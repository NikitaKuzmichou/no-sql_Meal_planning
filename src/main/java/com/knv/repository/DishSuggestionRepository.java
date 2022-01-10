package com.knv.repository;

import com.knv.dto.entity.DishSuggestionEntity;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DishSuggestionRepository {

    private static final String COLLECTION_NAME = "dish_suggestion";

    public static void insert(final MongoDatabase database, final DishSuggestionEntity entity) {
        database.getCollection(COLLECTION_NAME, DishSuggestionEntity.class)
                .insertOne(entity)
                .getInsertedId();
    }

    public static List<DishSuggestionEntity> selectBySuggestionId(
            final MongoDatabase database, final String suggestionId) {

        return database.getCollection(COLLECTION_NAME, DishSuggestionEntity.class)
                .find(Filters.eq(DishSuggestionEntity.Fields.id, suggestionId), DishSuggestionEntity.class)
                .into(new ArrayList<>());
    }

    public static void deleteBySuggestionId(final MongoDatabase database, final ObjectId suggestionId) {
        database.getCollection(COLLECTION_NAME, DishSuggestionEntity.class)
                .deleteOne(Filters.eq(DishSuggestionEntity.Fields.id, suggestionId));
    }
}
