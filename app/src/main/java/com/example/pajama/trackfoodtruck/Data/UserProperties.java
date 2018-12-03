package com.example.pajama.trackfoodtruck.Data;

import java.util.List;

public class UserProperties
{
	private List<String> favouriteFoodTrucks;
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<String> getFavouriteFoodTrucks()
	{
		return favouriteFoodTrucks;
	}

	public void setFavouriteFoodTrucks(List<String> favouriteFoodTrucks)
	{
		this.favouriteFoodTrucks = favouriteFoodTrucks;
	}

}
