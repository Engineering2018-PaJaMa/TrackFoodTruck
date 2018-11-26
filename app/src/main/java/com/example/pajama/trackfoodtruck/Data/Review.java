package com.example.pajama.trackfoodtruck.Data;

import java.util.Map;

public class Review
{

	private Map<String, Object> _id;
	private String restaurantName;
	private String headline;
	private String body;
	private Double rating;
	private String author;

	public String getRestaurantName()
	{
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName)
	{
		this.restaurantName = restaurantName;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getHeadline()
	{
		return headline;
	}

	public void setHeadline(String headline)
	{
		this.headline = headline;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public Double getRating()
	{
		return rating;
	}

	public void setRating(Double rating)
	{
		this.rating = rating;
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
