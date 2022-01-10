package com.knv.controller;

import com.knv.config.ServiceConfiguration;
import com.knv.dto.entity.DishSuggestionEntity;
import com.knv.dto.model.DishModel;
import com.knv.dto.model.DishSuggestionModel;
import com.knv.exception.ServerException;
import com.knv.service.DishService;
import com.knv.service.DishSuggestionService;
import com.mongodb.client.MongoClient;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.knv.dto.mapper.Mappers.DISH_SUGGESTION_MAPPER;

@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor(onConstructor = @__(@Autowired), access = AccessLevel.PRIVATE)
public class DishController {

    private final MongoClient client;

    @ApiOperation(value = "", response = ResponseEntity.class)
    @PostMapping("/add")
    public ResponseEntity addDishSuggestion(final @RequestBody DishSuggestionModel suggestion) {

        final DishSuggestionEntity entity = DISH_SUGGESTION_MAPPER.toEntity(suggestion);
        DishSuggestionService.insert(client.getDatabase(ServiceConfiguration.DATABASE_NAME), entity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "", response = DishModel.class)
    @PostMapping("/approve")
    public ResponseEntity<DishModel> approveDishSuggestion(
            final @RequestBody String suggestionId, final @RequestParam ObjectId userId)
            throws ServerException {

        final DishModel approvedDish = DishService.approveDishSuggestion(
                client.getDatabase(ServiceConfiguration.DATABASE_NAME), suggestionId, userId);

        return new ResponseEntity<>(approvedDish, HttpStatus.OK);
    }

    @ApiOperation(value = "", response = List.class)
    @GetMapping("/list")
    public ResponseEntity<List<DishModel>> list() {
        return new ResponseEntity<>(
                DishService.list(client.getDatabase(ServiceConfiguration.DATABASE_NAME)), HttpStatus.OK);
    }
}
