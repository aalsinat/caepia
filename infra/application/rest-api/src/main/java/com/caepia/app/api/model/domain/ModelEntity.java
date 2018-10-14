package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ModelEntity {

    public ModelEntity filter(List<String> properties) {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Converting POJO to Map
        Map<String, Object> map = mapper.convertValue(this, new TypeReference<Map<String, Object>>() {
        });

        // Fitlering POJO properties
        Map<String, Object> filtered = map.entrySet().stream()
                                          .filter(entry -> this.itemInList(entry.getKey(), properties))
                                          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // Convert Map to POJO
        ModelEntity anotherFoo = mapper.convertValue(filtered, this.getClass());
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
}
