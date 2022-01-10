package com.knv.service;

import com.knv.dto.entity.RationEntity;
import com.knv.dto.mapper.Mappers;
import com.knv.dto.model.RationModel;
import com.knv.exception.RationException;
import com.knv.repository.RationRepository;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RationService {

    public static void addRation(final MongoDatabase database, final RationEntity entity) {
        if (entity.getDate() == null) {
            entity.setDate(LocalDate.now());
        }

        entity.setRecommendations(RecommendationService.analyzeRation(database, entity));
        RationRepository.upsert(database, entity);
    }

    public static List<RationModel> selectRationsByUser(final MongoDatabase database, final ObjectId userId)
            throws RationException {

        return Optional.ofNullable(userId)
                .map(id -> RationRepository.listByUserId(database, id))
                .map(Mappers.RATION_MAPPER::toModel)
                .orElseThrow(() -> new RationException("User ID is null"));
    }
}
