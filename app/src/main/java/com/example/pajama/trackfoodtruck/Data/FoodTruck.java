package com.example.pajama.trackfoodtruck.Data;

import java.util.HashMap;
import java.util.Map;

public class FoodTruck{

	private Map<String, Object> _id;
    private String name;
    private String cuisine;
    private String description;
    private Location location;
    private Double rating;
    private String photo;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public Map<String, Object> get_id()
	{
		return _id;
	}

	public void set_id(Map<String, Object> _id)
	{
		this._id = _id;
	}

}