package com.android.contactapp.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("gender")
    public String gender;

    @SerializedName("name")
    public Name name;

    @SerializedName("location")
    public Location location;

    @SerializedName("email")
    public String email;

    @SerializedName("dob")
    public Dob dob;

    @SerializedName("phone")
    public String phone;

    @SerializedName("cell")
    public String cell;

    @SerializedName("picture")
    public Picture picture;

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Dob getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }
}
