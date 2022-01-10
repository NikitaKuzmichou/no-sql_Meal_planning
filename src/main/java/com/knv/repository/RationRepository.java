package com.knv.repository;

import com.knv.dto.entity.RationEntity;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RationRepository {

    private static final String COLLECTION_NAME = "ration";

    public static void upsert(final MongoDatabase database, final RationEntity entity) {
        database.getCollection(COLLECTION_NAME, RationEntity.class)
                .updateOne(
                        Filters.eq(RationEntity.Fields.id, entity.getId()),
                        List.of(
                                Updates.set(RationEntity.Fields.date, entity.getDate()),
                                Updates.set(RationEntity.Fields.dishes, entity.getDishes()),
                                Updates.set(RationEntity.Fields.userId, entity.getUserId()),
                                Updates.set(RationEntity.Fields.user, entity.getUser()),
                                Updates.set(RationEntity.Fields.recommendations, entity.getRecommendations())),
                        new UpdateOptions().upsert(true));
    }

    public static List<RationEntity> listByUserId(final MongoDatabase database, final ObjectId userId) {
        return database.getCollection(COLLECTION_NAME, RationEntity.class)
                .find(Filters.eq(RationEntity.Fields.userId, userId))
                .into(new ArrayList<>());
    }
}
