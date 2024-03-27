package com.stevezchao.carDistributionSystem.pojo.randomapi.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Location  implements Serializable {

    @JsonProperty("street")
    private Street street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

    @JsonProperty("timezone")
    private Timezone timezone;

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street=" + street +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postcode=" + postcode +
                ", coordinates=" + coordinates +
                ", timezone=" + timezone +
                '}';
    }
}