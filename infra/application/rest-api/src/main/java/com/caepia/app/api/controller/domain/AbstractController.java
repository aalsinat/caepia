package com.caepia.app.api.controller.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Slf4j
@RestController
public abstract class AbstractController {

    public final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); // ISO 8601

    // -----------------------------
    //  Class support methods
    // -----------------------------

    protected boolean isPageRequest(Optional<Integer> page, Optional<Integer> size) {
        return page.isPresent() && size.isPresent();
    }

    protected boolean isStatusFilter(Integer status) {
        return (!(status == null));
    }

    protected boolean isLogisticChainTypeFilter(Integer logisticChainType) {
        return (!(logisticChainType == null));
    }

    protected boolean isOwnerFilter(Integer owner) {
        return (!(owner == null));
    }

    protected boolean isProductionOrderFilter(Integer productionOrder) {
        return (!(productionOrder == null));
    }

    protected boolean isOrderDateFilter(String orderDate) {
        return (!(orderDate == null));
    }



    /**
     * Decrease the page number to adapt the API to the default page
     *
     * @param page identifier for the center
     * @return true if center is eligible, false otherwise
     */

    protected Integer transformDefaultPage(Integer page) {
        return (page-- <= 0 ? page = 0 : page);

    }


    protected Date getDate(String date) {

        try {
            if (isNull(date)) {
                return null;
            } else {
                return this.dateFormat.parse(date);
            }
        } catch (ParseException e) {
            return null;
        }
    }

    protected boolean isNull(Object obj) {
        return (obj == null);
    }

    public SecurityContext getContext() {
        return SecurityContextHolder.getContext();
    }

}