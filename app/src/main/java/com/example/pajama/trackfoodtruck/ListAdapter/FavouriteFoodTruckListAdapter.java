package com.example.pajama.trackfoodtruck.ListAdapter;

import java.util.ArrayList;

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
	private final ArrayList<String> nameArray;
	private final ArrayList<String> infoArray;
	private final ArrayList<Integer> imageArray;

	public FavouriteFoodTruckListAdapter(
			FragmentActivity context,
			ArrayList<String> nameArrayParam,
			ArrayList<String> infoArrayParam,
			ArrayList<Integer> imageArrayParam)
	{

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

		nameTextField.setText(nameArray.get(position));
		infoTextField.setText(infoArray.get(position));
		imageView.setImageResource(imageArray.get(position));

		return rowView;

	}
}
