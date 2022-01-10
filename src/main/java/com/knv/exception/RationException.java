package com.knv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such ration")
public class RationException extends ServerException {

    public RationException(final String message) {
        super(message);
    }
}
