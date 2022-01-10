package com.knv.service;

import com.knv.dto.entity.UserEntity;
import com.knv.exception.ServerException;
import com.knv.exception.UserException;
import com.knv.repository.UserRepository;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserService {

    public static UserEntity selectUser(final MongoDatabase database, final ObjectId userId) throws ServerException {
        return Optional.ofNullable(userId)
                .map(id -> UserRepository.selectUser(database, userId))
                .orElseThrow(() -> new UserException("No such user").setContextValue("ID", userId));
    }

    public static boolean isAdmin(final MongoDatabase database, final ObjectId userId) throws ServerException {
        final UserEntity user = selectUser(database, userId);

        return Objects.equals(UserEntity.ADMIN, user.getRole());
    }
}
