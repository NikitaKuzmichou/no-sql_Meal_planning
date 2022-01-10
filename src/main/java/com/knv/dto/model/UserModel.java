package com.knv.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

@Getter @Setter @Accessors(chain = true)
public class UserModel {
    private ObjectId id;
    private long role;
    private String login;
    private String password;
}
