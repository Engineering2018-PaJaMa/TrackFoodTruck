package com.example.pajama.trackfoodtruck.Fragments;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.Activities.DetailsActivity;
import com.example.pajama.trackfoodtruck.Data.FoodTruck;
import com.example.pajama.trackfoodtruck.ListAdapter.FavouriteFoodTruckListAdapter;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpTruckController.HttpGetAllTruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FavouriteFragment extends Fragment
{

	ArrayList<String> nameArray = new ArrayList<>();

	ArrayList<String> infoArray = new ArrayList<>();

	ArrayList<String> imageArray = new ArrayList<>();

	ArrayList<String> cuisineArray = new ArrayList<>();

	ArrayList<Double> raitingArray = new ArrayList<>();

	ListView listView;

	public static String choosenFoodTruck;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_favourite, container, false);

		HttpGetAllTruck truckProcess = new HttpGetAllTruck();
		truckProcess.execute();


		try
		{
			for (FoodTruck foodTruck : truckProcess.get())
			{

				nameArray.add(foodTruck.getName());
				infoArray.add(foodTruck.getDescription());
				imageArray.add(foodTruck.getPhoto());
				cuisineArray.add(foodTruck.getCuisine());
				raitingArray.add(foodTruck.getRating());
			}
		}
		catch (ExecutionException | InterruptedException e)
		{
			e.printStackTrace();
		}
		Log.e("qq", nameArray.get(0));


		FavouriteFoodTruckListAdapter favouriteFoodTruckListAdapter = new FavouriteFoodTruckListAdapter(
				getActivity(),
				nameArray,
				infoArray,
				imageArray,
				cuisineArray,
				raitingArray);

		listView = view.findViewById(R.id.favouriteListView);
		listView.setAdapter(favouriteFoodTruckListAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(
					AdapterView<?> arg0, View arg1, int position, long arg3)
			{
				choosenFoodTruck = nameArray.get(position);
				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
