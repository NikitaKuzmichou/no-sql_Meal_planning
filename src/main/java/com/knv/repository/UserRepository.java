package com.knv.repository;

import com.knv.dto.entity.UserEntity;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserRepository {

    private static final String COLLECTION_NAME = "user";

    public static UserEntity selectUser(final MongoDatabase database, final ObjectId userId) {
        return database.getCollection(COLLECTION_NAME, UserEntity.class)
                .find(Filters.eq(UserEntity.Fields.id, userId))
                .first();
    }
}
