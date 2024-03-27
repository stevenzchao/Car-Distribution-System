package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.List;

public class UserResponse  implements Serializable {

    @JsonProperty("results")
    private List<Result> results;

    @JsonProperty("info")
    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }
}