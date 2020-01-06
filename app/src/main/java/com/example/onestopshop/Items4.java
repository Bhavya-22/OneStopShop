package com.example.onestopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Items4 {
    private String name;
    private String price;
    private String profilePic;

    public Items4() {
    }

    public Items4(String name, String price, String profilePic) {
        this.name = name;
        this.price = price;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

}