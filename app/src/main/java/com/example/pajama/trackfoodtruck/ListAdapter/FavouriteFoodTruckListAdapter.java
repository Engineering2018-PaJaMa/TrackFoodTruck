package com.example.pajama.trackfoodtruck.ListAdapter;

import com.example.pajama.trackfoodtruck.R;


import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FavouriteFoodTruckListAdapter extends ArrayAdapter
{
	private final FragmentActivity context;
	private final String[] nameArray;
	private final String[] infoArray;
	private final Integer[] imageArray;

	public FavouriteFoodTruckListAdapter(FragmentActivity context, String[] nameArrayParam, String[] infoArrayParam,Integer[] imageArrayParam){

		super(context,R.layout.listview_row , nameArrayParam);

		this.context=context;
		this.nameArray = nameArrayParam;
		this.infoArray = infoArrayParam;
		this.imageArray = imageArrayParam;

	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.listview_row, null,true);

		TextView nameTextField = rowView.findViewById(R.id.foodTruckNameTextView);
		TextView infoTextField = rowView.findViewById(R.id.foodTruckInfoTextView);
		ImageView imageView = rowView.findViewById(R.id.foodTruckimageView);

		nameTextField.setText(nameArray[position]);
		infoTextField.setText(infoArray[position]);
		imageView.setImageResource(imageArray[position]);
		return rowView;

	};
}
