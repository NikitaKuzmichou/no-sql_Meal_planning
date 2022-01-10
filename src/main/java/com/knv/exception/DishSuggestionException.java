package com.knv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such dish suggestion")
public class DishSuggestionException extends ServerException {

    public DishSuggestionException(final String message) {
        super(message);
    }
}
