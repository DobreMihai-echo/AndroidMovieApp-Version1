package com.example.myandroidapplication.model;

import android.media.Image;

import java.io.Serializable;

public class Cast implements Serializable {

    private int fImage;
    private String fFirstName;
    private String fLastName;
    private String fDescription;

    public Cast(int fImage, String fFirstName, String fLastName, String fDescription) {
        this.fImage = fImage;
        this.fFirstName = fFirstName;
        this.fLastName = fLastName;
        this.fDescription = fDescription;
    }

    public int getfImage() {
        return fImage;
    }

    public void setfImage(int fImage) {
        this.fImage = fImage;
    }

    public String getfFirstName() {
        return fFirstName;
    }

    public void setfFirstName(String fFirstName) {
        this.fFirstName = fFirstName;
    }

    public String getfLastName() {
        return fLastName;
    }

    public void setfLastName(String fLastName) {
        this.fLastName = fLastName;
    }

    public String getfDescription() {
        return fDescription;
    }

    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }
}
