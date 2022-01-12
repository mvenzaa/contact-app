package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("title")
    public String title;

    @SerializedName("first")
    public String first;

    @SerializedName("last")
    public String last;

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
