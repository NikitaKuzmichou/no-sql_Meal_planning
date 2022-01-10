package com.knv.repository;

import com.knv.dto.entity.RecommendationEntity;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RecommendationRepository {

    private static final String COLLECTION_NAME = "recommendation";

    public static List<RecommendationEntity> recommendationByTypeAsc(final MongoDatabase database, final long type) {
        return database.getCollection(COLLECTION_NAME, RecommendationEntity.class)
                .find(Filters.eq(RecommendationEntity.Fields.type, type))
                .sort(Sorts.descending(RecommendationEntity.Fields.value))
                .into(new ArrayList<>());
    }
}
