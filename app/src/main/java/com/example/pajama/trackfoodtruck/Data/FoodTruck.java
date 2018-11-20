package com.example.pajama.trackfoodtruck.Data;

import android.location.Location;

public class FoodTruck {
    private String id;

    private String name;

    private String owner;
    private String typeOfFood;
    private String description;
    private Location location;
    private String photo;
    private Double rating;
    private String reviews;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location;
    }

    public String getPhoto() {
        return photo;
    }

    public Double getRating() {
        return rating;
    }

    public String getReviews() {
        return reviews;
    }
}
