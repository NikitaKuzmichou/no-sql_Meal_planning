package com.knv.service;

import com.knv.dto.entity.DishEntity;
import com.knv.dto.entity.DishSuggestionEntity;
import com.knv.dto.mapper.Mappers;
import com.knv.dto.model.DishModel;
import com.knv.exception.DishSuggestionException;
import com.knv.exception.ServerException;
import com.knv.exception.UserException;
import com.knv.repository.DishRepository;
import com.knv.repository.DishSuggestionRepository;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DishService {

    public static List<DishModel> list(final MongoDatabase database) {
        return Mappers.DISH_MAPPER.toModel(DishRepository.list(database));
    }

    public static DishModel approveDishSuggestion(
            final MongoDatabase database, final String dishSuggestionId, final ObjectId userId)
            throws ServerException {

        if (userId == null) {
            throw new UserException("User id is null");
        } else if (dishSuggestionId == null) {
            throw new DishSuggestionException("Dish suggestion is null");
        } else if (!UserService.isAdmin(database, userId)) {
            throw new UserException("User have not enough permissions to approve dish suggestions")
                    .setContextValue("ID", userId);
        }

        final DishSuggestionEntity dishSuggestion = DishSuggestionRepository.selectBySuggestionId(
                database, dishSuggestionId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new DishSuggestionException("Dish suggestion not found"));

        DishSuggestionRepository.deleteBySuggestionId(database, dishSuggestion.getId());
        insert(database, dishSuggestion.getDish());

        return Mappers.DISH_MAPPER.toModel(dishSuggestion.getDish());
    }

    public static void insert(final MongoDatabase database, final DishEntity entity) {
        DishRepository.insert(database, entity);
    }
}
