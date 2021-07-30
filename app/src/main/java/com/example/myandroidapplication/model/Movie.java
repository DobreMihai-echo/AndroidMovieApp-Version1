package com.example.myandroidapplication.model;

import android.media.Image;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    private int fImage;
    private int fbackImg;
    private String fName;
    private String fDescription;
    private List<Cast> fListOfCast;

    public Movie() {
    }

    public Movie(int fImage, String fName) {
        this.fImage = fImage;
        this.fName = fName;
        this.fDescription = null;
    }

    public Movie(int fImage,int fbackImg, String fName, String fDescription) {
        this.fImage = fImage;
        this.fName = fName;
        this.fDescription = fDescription;
    }

    public Movie(int fImage,int fbackImg, String fName, String fDescription, List<Cast> fListOfCast) {
        this.fImage = fImage;
        this.fName = fName;
        this.fDescription = fDescription;
        this.fListOfCast = fListOfCast;
        this.fbackImg = fbackImg;
    }

    public int getFbackImg() {
        return fbackImg;
    }

    public void setFbackImg(int fbackImg) {
        this.fbackImg = fbackImg;
    }

    public List<Cast> getfListOfCast() {
        return fListOfCast;
    }

    public void setfListOfCast(List<Cast> fListOfCast) {
        this.fListOfCast = fListOfCast;
    }

    public int getfImage() {
        return fImage;
    }

    public void setfImage(int fImage) {
        this.fImage = fImage;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfDescription() {
        return fDescription;
    }

    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }

}
