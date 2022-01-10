package com.knv.controller;

import com.knv.dto.entity.RationEntity;
import com.knv.dto.mapper.Mappers;
import com.knv.dto.model.RationModel;
import com.knv.exception.RationException;
import com.knv.service.RationService;
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

import static com.knv.config.ServiceConfiguration.DATABASE_NAME;

@RestController
@RequestMapping("/api/ration")
@AllArgsConstructor(onConstructor = @__(@Autowired), access = AccessLevel.PRIVATE)
public class RationController {

    private final MongoClient client;

    @ApiOperation(value = "", response = ResponseEntity.class)
    @PostMapping("/add")
    public ResponseEntity addRation(final @RequestBody RationModel ration) {
        final RationEntity rationEntity = Mappers.RATION_MAPPER.toEntity(ration);
        RationService.addRation(client.getDatabase(DATABASE_NAME), rationEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "", response = List.class)
    @GetMapping("/info")
    public ResponseEntity<List<RationModel>> info(final @RequestParam ObjectId userId) throws RationException {
        final List<RationModel> rations = RationService.selectRationsByUser(client.getDatabase(DATABASE_NAME), userId);

        return new ResponseEntity<>(rations, HttpStatus.OK);
    }
}
