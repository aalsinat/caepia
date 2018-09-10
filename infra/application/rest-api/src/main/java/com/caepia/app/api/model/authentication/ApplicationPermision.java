package com.caepia.app.api.model.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ApplicationPermision {
    @JsonIgnore
    public String getProfile();

    @JsonIgnore
    public String getActions();
}
