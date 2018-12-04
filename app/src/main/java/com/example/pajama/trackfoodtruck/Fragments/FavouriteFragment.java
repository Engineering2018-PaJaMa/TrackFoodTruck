package com.example.pajama.trackfoodtruck.Fragments;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.Activities.DetailsActivity;
import com.example.pajama.trackfoodtruck.Activities.LoginActivity;
import com.example.pajama.trackfoodtruck.Adapters.FavouriteFoodTruckListAdapter;
import com.example.pajama.trackfoodtruck.Data.ApplicationData;
import com.example.pajama.trackfoodtruck.Data.FoodTruck;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpTruckController.HttpGetAllTruck;
import com.example.pajama.trackfoodtruck.httpUserController.HttpGetUser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

	ArrayList<String> favouriteArray = new ArrayList<>();

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

		HttpGetUser getUser = new HttpGetUser();
		getUser.execute(LoginActivity.currentUserEmail);

		try
		{
			favouriteArray.addAll(getUser.get().getFavouriteFoodTrucks());
			for (FoodTruck foodTruck : truckProcess.get())
			{
				for (String favFoodTrack : favouriteArray)
				{
					if (foodTruck.getName().equals(favFoodTrack))
					{
						nameArray.add(foodTruck.getName());
						infoArray.add(foodTruck.getDescription());
						imageArray.add(foodTruck.getPhoto());
						cuisineArray.add(foodTruck.getCuisine());
						raitingArray.add(foodTruck.getRating());
					}
				}
			}
		}
		catch (ExecutionException | InterruptedException e)
		{
			e.printStackTrace();
		}

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
				ApplicationData.choosenTrack = nameArray.get(position);
				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
