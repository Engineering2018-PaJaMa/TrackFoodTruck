package com.example.pajama.trackfoodtruck.Data;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private String country;
    private String city;
    private Integer latitude;
    private Integer longitude;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCountry()
	{
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
