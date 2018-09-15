package com.caepia.app.api.exception;

import lombok.Getter;

@Getter
public class CenterNotAccessibleException extends RuntimeException {
    private final Integer centerId;

    public CenterNotAccessibleException(String message, Integer centerId) {
        super(message);
        this.centerId = centerId;
    }
}
