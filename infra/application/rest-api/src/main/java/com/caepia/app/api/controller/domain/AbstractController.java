package com.caepia.app.api.controller.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
     * Method for
     *
     * @param source
     * @param properties
     * @param <T>
     * @return
     */
    protected Iterable<ModelEntity> includeProperties(Iterable<ModelEntity> source, List<String> properties) {
        if (source instanceof List) {
            return StreamSupport.stream(source.spliterator(), false)
                                .map(item -> item.filter(properties))
                                .collect(Collectors.toList());
        } else {
            List<ModelEntity> listOfFoos = ((PageImpl<ModelEntity>) source).getContent().stream()
                                                                           .map(item -> item.filter(properties))
                                                                           .collect(Collectors.toList());
            return new PageImpl<>(listOfFoos, PageRequest.of(
                    ((PageImpl<ModelEntity>) source).getNumber(),
                    ((PageImpl<ModelEntity>) source).getSize(),
                    ((PageImpl<ModelEntity>) source).getSort()),
                    listOfFoos.size());
        }
    }


    /**
     * Support method for filter object properties using a list of requested ones.
     *
     * @param source     object whose properties must be filtered
     * @param properties list of required properties
     * @return source object with only filtered properties
     */
    protected <T> T filterProperties(T source, List<String> properties) {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Converting POJO to Map
        Map<String, Object> map = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
        });

        // Fitlering POJO properties
        Map<String, Object> filtered = map.entrySet().stream()
                                          .filter(entry -> this.itemInList(entry.getKey(), properties))
                                          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // Convert Map to POJO
        T anotherFoo = (T) mapper.convertValue(filtered, source.getClass());
        return anotherFoo;
    }


    /**
     * Support method to search for a particular item within a list.
     *
     * @param item item to be found
     * @param list list of elements to search in
     * @return {@literal true} if item is within the list, {@literal false} otherwise
     */
    private boolean itemInList(String item, List<String> list) {
        return list.stream().anyMatch(itemList -> itemList.equalsIgnoreCase(item));
    }


    /**
     * Support method for retrieving a list from a comma-separated string
     *
     * @param inline a string with comma separated elements
     * @return a list of string elements
     */
    protected List<String> getListFromString(String inline) {
        return Arrays.asList(inline.trim().split(","));
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