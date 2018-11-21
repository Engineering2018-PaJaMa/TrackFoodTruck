package com.example.pajama.trackfoodtruck.Fragments;

import com.example.pajama.trackfoodtruck.Activities.DetailsActivity;
import com.example.pajama.trackfoodtruck.ListAdapter.FavouriteFoodTruckListAdapter;
import com.example.pajama.trackfoodtruck.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FavouriteFragment extends Fragment
{

	String[] nameArray = { "FoodTruck1", "FoodTruck2", "FoodTruck3", "FoodTruck4" };

	String[] infoArray = { "cuisine type1", "cuisine type2", "cuisine type3", "cuisine type4" };

	Integer[] imageArray = { R.drawable.foodtrucksample,R.drawable.foodtrucksample,R.drawable.foodtrucksample,R.drawable.foodtrucksample, };

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
		FavouriteFoodTruckListAdapter favouriteFoodTruckListAdapter = new FavouriteFoodTruckListAdapter(getActivity(), nameArray, infoArray, imageArray);

		listView = view.findViewById(R.id.favouriteListView);
		listView.setAdapter(favouriteFoodTruckListAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub


				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				startActivity(intent);


			}
		});

		return view;
	}




}
