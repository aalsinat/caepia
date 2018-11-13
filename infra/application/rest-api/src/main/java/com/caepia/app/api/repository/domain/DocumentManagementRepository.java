package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface DocumentManagementRepository {

    StoredProcedureResult createLogEntry(Integer logProces, Integer logEventType, String description, String extraInfo, String deviceInfo, Integer userId);

}