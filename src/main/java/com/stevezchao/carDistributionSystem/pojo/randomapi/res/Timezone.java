package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Timezone  implements Serializable {

    @JsonProperty("offset")
    private String offset;

    @JsonProperty("description")
    private String description;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "offset='" + offset + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}