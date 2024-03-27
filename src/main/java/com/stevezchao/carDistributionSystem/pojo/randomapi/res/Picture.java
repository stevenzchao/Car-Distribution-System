package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Picture  implements Serializable {

    @JsonProperty("large")
    private String large;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("thumbnail")
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}