package com.caepia.app.api.exception;

import lombok.Getter;

@Getter
public class UpdateProductBookmarkException extends RuntimeException {
    private Integer centerId;
    private Integer vendorId;
    private Integer productId;

    public UpdateProductBookmarkException(String message, Integer centerId, Integer vendorId, Integer productId) {
        super(String.format(message, productId, vendorId, centerId));
        this.centerId = centerId;
        this.vendorId = vendorId;
        this.productId = productId;
    }
}
