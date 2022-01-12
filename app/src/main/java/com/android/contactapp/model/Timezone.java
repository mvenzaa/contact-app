package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("offset")
    public String offset;

    @SerializedName("description")
    public String description;

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }
}
