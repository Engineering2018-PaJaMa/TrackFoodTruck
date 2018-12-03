package com.example.pajama.trackfoodtruck.Adapters;

import java.util.ArrayList;

import com.example.pajama.trackfoodtruck.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ReviewListAdapter extends ArrayAdapter
{
	private final Activity context;
	private final ArrayList<String> dateArray;
	private final ArrayList<String> authorNameArray;
	private final ArrayList<String> reviewArray;

	public ReviewListAdapter(Activity context, ArrayList<String> dateArray, ArrayList<String> authorNameArray, ArrayList<String> reviewArrayParam)
	{

		super(context, R.layout.listview_row, reviewArrayParam);

		this.context = context;
		this.dateArray = dateArray;
		this.authorNameArray = authorNameArray;
		this.reviewArray = reviewArrayParam;

	}

	public View getView(int position, View view, ViewGroup parent)
	{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.detailslistview_row, null, true);

		TextView dateTextField = rowView.findViewById(R.id.detailDateTextView);
		TextView authorNameTextField = rowView.findViewById(R.id.detailsAuthorReviewextView);
		TextView reviewTextField = rowView.findViewById(R.id.reviewTextView);

		dateTextField.setText(dateArray.get(position));
		authorNameTextField.setText(authorNameArray.get(position));
		reviewTextField.setText(reviewArray.get(position));

		return rowView;

	}

	;
}
