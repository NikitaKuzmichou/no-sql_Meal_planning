package com.knv.service;

import com.knv.dto.entity.DishEntity;
import com.knv.dto.entity.RationEntity;
import com.knv.dto.entity.RecommendationEntity;
import com.knv.repository.RecommendationRepository;
import com.mongodb.client.MongoDatabase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.knv.dto.entity.RecommendationEntity.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RecommendationService {

    public static List<RecommendationEntity> analyzeRation(final MongoDatabase database, final RationEntity ration) {
        double totalProteins = 0;
        double totalFats = 0;
        double totalCarbohydrates = 0;
        double totalCalories = 0;

        for (final DishEntity dish : ration.getDishes()) {
            if (dish.getCarbohydrates() != null) {
                totalCarbohydrates += dish.getCarbohydrates();
            }

            if (dish.getFats() != null) {
                totalFats += dish.getFats();
            }

            if (dish.getProteins() != null) {
                totalProteins += dish.getProteins();
            }

            if (dish.getCalories() != null) {
                totalCalories += dish.getCalories();
            }
        }

        final RecommendationEntity proteins = findRecommendation(database, PROTEINS, totalProteins);
        final RecommendationEntity fats = findRecommendation(database, FATS, totalFats);
        final RecommendationEntity carbohydrates = findRecommendation(database, CARBOHYDRATES, totalCarbohydrates);
        final RecommendationEntity calories = findRecommendation(database, CALORIES, totalCalories);

        final List<RecommendationEntity> dishRecommendations = new ArrayList<>();

        if (proteins != null) {
            dishRecommendations.add(proteins);
        }

        if (fats != null) {
            dishRecommendations.add(fats);
        }

        if (carbohydrates != null) {
            dishRecommendations.add(carbohydrates);
        }

        if (calories != null) {
            dishRecommendations.add(calories);
        }

        return dishRecommendations;
    }

    public static List<RecommendationEntity> recommendationByTypeAsc(final MongoDatabase database, final long type) {
        return RecommendationRepository.recommendationByTypeAsc(database, type);
    }

    private static RecommendationEntity findRecommendation(final MongoDatabase database, long type, double total) {
        for (final RecommendationEntity recommendation : recommendationByTypeAsc(database, type)) {
            if (total <= recommendation.getValue()) {
                return recommendation;
            }
        }

        return null;
    }
}
