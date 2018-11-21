package com.example.pajama.trackfoodtruck.Fragments;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;
import com.example.pajama.trackfoodtruck.ListAdapter.FavouriteFoodTruckListAdapter;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpTruckController.HttpGetAllTruck;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FavouriteFragment extends Fragment
{

	ArrayList<String> nameArray = new ArrayList<>();

	ArrayList<String> infoArray = new ArrayList<>();

	ArrayList<Integer> imageArray = new ArrayList<>();
	ListView listView;

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
				imageArray.add(Integer.parseInt(foodTruck.getPhoto()));
			}
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		FavouriteFoodTruckListAdapter favouriteFoodTruckListAdapter = new FavouriteFoodTruckListAdapter(getActivity(), nameArray, infoArray, imageArray);

		listView = view.findViewById(R.id.favouriteListView);
		listView.setAdapter(favouriteFoodTruckListAdapter);
		return view;
	}
}
