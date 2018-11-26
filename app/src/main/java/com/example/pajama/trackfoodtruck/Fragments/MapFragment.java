package com.example.pajama.trackfoodtruck.Fragments;

import com.example.pajama.trackfoodtruck.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment implements OnMapReadyCallback
{

	MapView mapView;

	public MapFragment()
	{
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_map, container, false);

		mapView = (MapView) view.findViewById(R.id.mapView);
		mapView.onCreate(savedInstanceState);

		mapView.getMapAsync(this);

		return view;
	}

	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
	}
}
