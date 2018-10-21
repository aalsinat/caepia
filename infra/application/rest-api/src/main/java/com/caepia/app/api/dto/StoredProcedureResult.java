package com.caepia.app.api.dto;

import com.caepia.app.api.model.domain.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoredProcedureResult{
    private Integer errorCode;
    private String errorMessage;
    private Integer resultCode;
}