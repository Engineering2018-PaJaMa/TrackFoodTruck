package com.example.pajama.trackfoodtruck.Adapters;

import java.util.ArrayList;

import com.example.pajama.trackfoodtruck.R;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FavouriteFoodTruckListAdapter extends ArrayAdapter
{
	private final FragmentActivity context;
	private final ArrayList<String> nameArray;
	private final ArrayList<String> infoArray;
	private final ArrayList<String> cuisineArray;
	private final ArrayList<String> imageArray;
	private final ArrayList<Double> raitingArray;

	public FavouriteFoodTruckListAdapter(
			FragmentActivity context,
			ArrayList<String> nameArrayParam,
			ArrayList<String> infoArrayParam, ArrayList<String> imageArrayParam, ArrayList<String> cuisineArray, ArrayList<Double> raitingArray)
	{

		super(context,R.layout.listview_row , nameArrayParam);

		this.context=context;
		this.nameArray = nameArrayParam;
		this.infoArray = infoArrayParam;
		this.imageArray = imageArrayParam;
		this.cuisineArray = cuisineArray;
		this.raitingArray = raitingArray;

	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.listview_row, null,true);

		TextView nameTextField = rowView.findViewById(R.id.foodTruckNameTextView);
		TextView infoTextField = rowView.findViewById(R.id.foodTruckInfoTextView);
		TextView cuisineTextField = rowView.findViewById(R.id.cuisineTextView);
		RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);
		ImageView imageView = rowView.findViewById(R.id.foodTruckimageView);


		nameTextField.setText(nameArray.get(position));
		Log.e("QQQQQQQQ", nameArray.get(position));
		infoTextField.setText(infoArray.get(position));
		cuisineTextField.setText(cuisineArray.get(position));
		ratingBar.setRating(raitingArray.get(position).floatValue());
		//imageView.setImageResource(imageArray.get(position)); TODO:Images

		return rowView;

	}
}
