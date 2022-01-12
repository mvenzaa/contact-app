package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Dob {

    @SerializedName("date")
    public String date;

    @SerializedName("age")
    public String age;

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }
}
