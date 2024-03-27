package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Name  implements Serializable {

    @JsonProperty("title")
    private String title;

    @JsonProperty("first")
    private String first;

    @JsonProperty("last")
    private String last;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
