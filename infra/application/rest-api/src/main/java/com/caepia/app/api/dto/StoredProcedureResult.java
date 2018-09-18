package com.caepia.app.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoredProcedureResult {
    private Integer errorCode;
    private String errorMessage;
}