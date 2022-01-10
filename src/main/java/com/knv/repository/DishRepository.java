package com.knv.repository;

import com.knv.dto.entity.DishEntity;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DishRepository {

    private static final String COLLECTION_NAME = "dish";

    public static List<DishEntity> list(final MongoDatabase database) {
        return database.getCollection(COLLECTION_NAME, DishEntity.class)
                .find()
                .into(new ArrayList<>());
    }

    public static void insert(final MongoDatabase database, final DishEntity dish) {
        database.getCollection(COLLECTION_NAME, DishEntity.class)
                .insertOne(dish);
    }
}
