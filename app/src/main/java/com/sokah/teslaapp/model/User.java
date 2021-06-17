package com.sokah.teslaapp.model;

public class User {

    String id,name,email,profilePicUrl;

    public User(){

    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        profilePicUrl ="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }
}
