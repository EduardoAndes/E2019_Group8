package com.example.agricultureapplication;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("Firstname")
    private String FirstName;

    @SerializedName("Lastname")
    private String LastName;

    @SerializedName("Birthday")
    private String Birthday;

    @SerializedName("Age")
    private String Age;

    @SerializedName("Email")
    private String Email;

    @SerializedName("Username")
    private String Username;

    @SerializedName("Password")
    private String Password;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getBirthday() { return Birthday; }

    public String getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}

