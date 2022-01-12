package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Picture {

    @SerializedName("large")
    public String large;

    @SerializedName("medium")
    public String medium;

    @SerializedName("thumbnail")
    public String thumbnail;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
