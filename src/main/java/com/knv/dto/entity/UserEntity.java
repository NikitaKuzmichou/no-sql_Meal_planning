package com.knv.dto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter @Setter @Accessors(chain = true)
@FieldNameConstants
public class UserEntity {

    public static final long ADMIN = 0;
    public static final long USER = 1;

    private ObjectId id = ObjectId.get();
    private long role;
    private String login;
    private String password;
}
