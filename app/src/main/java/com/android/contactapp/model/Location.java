package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("street")
    public Street street;

    @SerializedName("city")
    public String city;

    @SerializedName("state")
    public String state;

    @SerializedName("country")
    public String country;

    @SerializedName("postcode")
    public String postcode;

    @SerializedName("coordinates")
    public Coordinates coordinates;

    @SerializedName("timezone")
    public Timezone timezone;

    public Street getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Timezone getTimezone() {
        return timezone;
    }
}
