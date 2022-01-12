package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("number")
    public String number;

    @SerializedName("name")
    public String name;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
