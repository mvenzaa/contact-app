package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Coordinates {

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
