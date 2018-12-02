package com.example.pajama.trackfoodtruck.Fragments;

import com.example.pajama.trackfoodtruck.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

public class MapFragment extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener,
		ActivityCompat.OnRequestPermissionsResultCallback
{
	private GoogleMap mMap;
	private boolean mLocationPermissionGranted;
	private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

	public MapFragment()
	{
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_map);

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}

	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		mMap = googleMap;

		mMap.setOnMyLocationButtonClickListener(this);
		mMap.setOnMyLocationClickListener(this);
		enableMyLocation();
	}

	@Override
	public boolean onMyLocationButtonClick()
	{
		return false;
	}

	@Override
	public void onMyLocationClick(@NonNull Location location)
	{
		Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
	}

	private void enableMyLocation()
	{
		if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
				== PackageManager.PERMISSION_GRANTED)
		{
			mLocationPermissionGranted = true;
		}
		else
		{
			ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
	{
		mLocationPermissionGranted = false;
		switch (requestCode)
		{
			case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:
			{
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
				{
					mLocationPermissionGranted = true;
				}
			}
		}
		updateLocationUI();
	}

	private void updateLocationUI()
	{
		if (mMap == null)
		{
			return;
		}
		try
		{
			if (mLocationPermissionGranted)
			{
				mMap.setMyLocationEnabled(true);
				mMap.getUiSettings().setMyLocationButtonEnabled(true);
			}
			else
			{
				mMap.setMyLocationEnabled(false);
				mMap.getUiSettings().setMyLocationButtonEnabled(false);
				Toast.makeText(this, "Need permission", Toast.LENGTH_LONG).show();
				enableMyLocation();
			}
		}
		catch (SecurityException e)
		{
			Log.e("Exception: %s", e.getMessage());
		}
	}
}
