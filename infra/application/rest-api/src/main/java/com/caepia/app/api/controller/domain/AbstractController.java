package com.caepia.app.api.controller.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public abstract class AbstractController {
    public final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); // ISO 8601

    // ---------------
    // Support methods
    // ---------------
    protected boolean isPageRequest(Integer page, Integer size) {
        return (!(page == null || (size == null)));
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

}