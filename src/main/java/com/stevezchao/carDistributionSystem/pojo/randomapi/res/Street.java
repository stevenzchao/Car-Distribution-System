package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Street  implements Serializable {

    @JsonProperty("number")
    private int number;

    @JsonProperty("name")
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}