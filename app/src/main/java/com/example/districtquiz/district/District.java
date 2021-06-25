package com.example.districtquiz.district;

import java.io.Serializable;

public class District implements Serializable {

    private int id;
    private String name;
    private String description;
    private float longitude;
    private float latitude;
    private int imageResource;

    public District(int id, String name, String description, float longitude, float latitude, int imageResource) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setLongitude(longitude);
        this.setLatitude(latitude);
        this.setImageResource(imageResource);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

}
