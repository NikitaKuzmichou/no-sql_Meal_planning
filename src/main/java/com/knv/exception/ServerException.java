package com.knv.exception;

import org.apache.commons.lang3.exception.ContextedException;

public abstract class ServerException extends ContextedException {

    private String info;

    public ServerException(final String message) {
        super(message);
    }

    public ServerException(final Throwable cause) {
        super(null, cause);
    }

    public ServerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    public ServerException setContextValue(final String label, final Object value) {
        super.setContextValue(label, value);
        return this;
    }
}
