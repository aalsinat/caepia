package com.caepia.app.api.exception;

import lombok.Getter;

@Getter
public class SendOrderException extends RuntimeException {
    private Integer orderId;
    private Integer userId;


    public SendOrderException(String message, Integer orderId, Integer userId) {
        super(String.format(message, orderId, userId));
        this.orderId = orderId;
        this.userId = userId;

    }
}
