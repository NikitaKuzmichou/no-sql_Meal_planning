package com.knv.db.migrations;

import com.knv.dto.entity.*;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public final class DbFiller {

    public static void fill(final MongoDatabase database) {
        DbFiller.users(database);
        DbFiller.products(database);
        DbFiller.dishes(database);
        DbFiller.dishSuggestions(database);
        DbFiller.rations(database);
        DbFiller.recommendations(database);
    }

    private static void users(final MongoDatabase database) {
        database.getCollection("user", UserEntity.class)
                .insertMany(List.of(
                        new UserEntity()
                                .setLogin("user@user.ru")
                                .setPassword("1234") // yeah must be encrypted, I know
                                .setRole(UserEntity.ADMIN),
                        new UserEntity()
                                .setLogin("usr@usr.ru")
                                .setPassword("1234") // yeah must be encrypted, I know
                                .setRole(UserEntity.USER)));
    }

    private static void products(final MongoDatabase database) {
        database.getCollection("product", ProductEntity.class)
                .insertMany(List.of(
                        new ProductEntity()
                                .setName("Apple")
                                .setCalories(1.04)
                                .setCarbohydrates(4.32)
                                .setFats(43.2)
                                .setProteins(22.3),
                        new ProductEntity()
                                .setName("Orange")
                                .setCalories(1.04)
                                .setCarbohydrates(4.32)
                                .setFats(43.2)
                                .setProteins(22.3),
                        new ProductEntity()
                                .setName("Cheese")
                                .setCalories(32.04)
                                .setCarbohydrates(5.32)
                                .setFats(41.32)
                                .setProteins(43.4),
                        new ProductEntity()
                                .setName("Fried student")
                                .setCalories(87.97)
                                .setCarbohydrates(0.43)
                                .setFats(42.0)
                                .setProteins(66.6),
                        new ProductEntity()
                                .setName("Oil")
                                .setCalories(4.43)
                                .setCarbohydrates(2.32)
                                .setFats(3.2)
                                .setProteins(9.3)));
    }

    private static void dishes(final MongoDatabase database) {
        database.getCollection("dish", DishEntity.class)
                .insertMany(List.of(new DishEntity()
                                .setName("Deep fried student")
                                .setCalories(44.44)
                                .setCarbohydrates(44.4)
                                .setFats(21.31)
                                .setProteins(55.5)
                                .setProducts(List.of(
                                        new ProductEntity()
                                                .setName("Cheese")
                                                .setCalories(32.04)
                                                .setCarbohydrates(5.32)
                                                .setFats(41.32)
                                                .setProteins(43.4),
                                        new ProductEntity()
                                                .setName("Fried student")
                                                .setCalories(87.97)
                                                .setCarbohydrates(0.43)
                                                .setFats(42.0)
                                                .setProteins(66.6),
                                        new ProductEntity()
                                                .setName("Oil")
                                                .setCalories(4.43)
                                                .setCarbohydrates(2.32)
                                                .setFats(3.2)
                                                .setProteins(9.3),
                                        new ProductEntity()
                                                .setName("Apple")
                                                .setCalories(1.04)
                                                .setCarbohydrates(4.32)
                                                .setFats(43.2)
                                                .setProteins(22.3))),
                        new DishEntity()
                                .setName("Cooked fish")
                                .setCalories(43.0)
                                .setCarbohydrates(41.2)
                                .setFats(5.42)
                                .setProteins(6.54)
                                .setProducts(List.of(
                                        new ProductEntity()
                                                .setName("Apple")
                                                .setCalories(1.04)
                                                .setCarbohydrates(4.32)
                                                .setFats(43.2)
                                                .setProteins(22.3),
                                        new ProductEntity()
                                                .setName("Fish")
                                                .setCalories(10.04)
                                                .setCarbohydrates(44.32)
                                                .setFats(437.2)
                                                .setProteins(122.3)))));
    }

    private static void dishSuggestions(final MongoDatabase database) {
        final ObjectId dishId = ObjectId.get();
        final ObjectId userId = ObjectId.get();

        database.getCollection("dish_suggestion", DishSuggestionEntity.class)
                .insertOne(
                        new DishSuggestionEntity()
                                .setDate(LocalDate.now())
                                .setDishId(dishId)
                                .setUserId(userId)
                                .setUser(new UserEntity()
                                        .setId(userId)
                                        .setLogin("kn@user.ru")
                                        .setPassword("1234")
                                        .setRole(UserEntity.USER))
                                .setDish(new DishEntity()
                                        .setId(dishId)
                                        .setName("Raw fish")
                                        .setCalories(1.0)
                                        .setCarbohydrates(1.2)
                                        .setFats(3.42)
                                        .setProteins(6.54)
                                        .setProducts(List.of(
                                                new ProductEntity()
                                                        .setName("Apple")
                                                        .setCalories(1.04)
                                                        .setCarbohydrates(4.32)
                                                        .setFats(43.2)
                                                        .setProteins(22.3),
                                                new ProductEntity()
                                                        .setName("Raw fish")
                                                        .setCalories(0.04)
                                                        .setCarbohydrates(5.32)
                                                        .setFats(3.2)
                                                        .setProteins(2.3)))));
    }

    private static void rations(final MongoDatabase database) {
        final ObjectId userId = ObjectId.get();

        database.getCollection("ration", RationEntity.class)
                .insertOne(new RationEntity()
                        .setDate(LocalDate.now())
                        .setDishes(List.of(
                                new DishEntity()
                                        .setName("Garbage")
                                        .setCalories(12.0)
                                        .setCarbohydrates(431.2)
                                        .setFats(223.42)
                                        .setProteins(326.54)
                                        .setProducts(List.of(
                                                new ProductEntity()
                                                        .setName("CoD vanguard")
                                                        .setCalories(54.04)
                                                        .setCarbohydrates(12.32)
                                                        .setFats(43.2)
                                                        .setProteins(22.3),
                                                new ProductEntity()
                                                        .setName("Modern AAA games")
                                                        .setCalories(889.04)
                                                        .setCarbohydrates(343.32)
                                                        .setFats(2222.2)
                                                        .setProteins(43.3)))))
                        .setRecommendations(null)
                        .setUserId(userId)
                        .setUser(new UserEntity()
                                .setId(userId)
                                .setRole(UserEntity.USER)
                                .setLogin("random_login@user.com")
                                .setPassword("1234")));

    }

    private static void recommendations(final MongoDatabase database) {
        database.getCollection("recommendation", RecommendationEntity.class)
                .insertMany(List.of(
                        new RecommendationEntity()
                                .setName("Too much proteins")
                                .setType(RecommendationEntity.PROTEINS)
                                .setValue(9999999999.7)
                                .setDescription("You should eat less proteins"),
                        new RecommendationEntity()
                                .setName("Too much fats")
                                .setType(RecommendationEntity.FATS)
                                .setValue(9999999999.7)
                                .setDescription("You should eat less fats"),
                        new RecommendationEntity()
                                .setName("Too much carbohydrates")
                                .setType(RecommendationEntity.CARBOHYDRATES)
                                .setValue(9999999999.7)
                                .setDescription("You should eat less carbohydrates"),
                        new RecommendationEntity()
                                .setName("Too much calories")
                                .setType(RecommendationEntity.CALORIES)
                                .setValue(9999999999.7)
                                .setDescription("You should eat less calories"),
                        new RecommendationEntity()
                                .setName("Eat something")
                                .setType(RecommendationEntity.CALORIES)
                                .setValue(250)
                                .setDescription("You eat at least something")));
    }
}
