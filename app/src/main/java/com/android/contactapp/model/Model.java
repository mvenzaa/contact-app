package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("results")
    public List<Results> results;

    public List<Results> getResults() {
        return results;
    }
}
