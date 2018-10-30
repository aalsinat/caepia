package com.caepia.app.api.dto;

import com.caepia.app.api.model.domain.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoredProcedureResult{
    private Integer errorCode;
    private String errorMessage;
    private Integer resultCode;
    private String whatsAppBody;
    private String whatsAppTel;
}