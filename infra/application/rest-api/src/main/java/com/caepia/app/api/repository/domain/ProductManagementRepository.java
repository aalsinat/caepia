package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface ProductManagementRepository {
    StoredProcedureResult updateBookmark(Integer vendorId, Integer centerId, Integer productId, Integer isBookmarked);
}
