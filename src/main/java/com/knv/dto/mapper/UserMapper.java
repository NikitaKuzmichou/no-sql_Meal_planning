package com.knv.dto.mapper;

import com.knv.dto.entity.UserEntity;
import com.knv.dto.model.UserModel;

import java.util.Optional;

public class UserMapper implements Mapper<UserEntity, UserModel> {

    @Override
    public UserEntity toEntity(final UserModel model) {
        return Optional.ofNullable(model)
                .map(dto -> new UserEntity()
                        .setLogin(dto.getLogin())
                        .setPassword(dto.getPassword())
                        .setRole(model.getRole()))
                .orElse(null);
    }

    @Override
    public UserModel toModel(final UserEntity user) {
        return new UserModel()
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .setRole(user.getRole());
    }
}
