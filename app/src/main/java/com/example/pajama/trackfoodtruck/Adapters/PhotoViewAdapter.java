package com.example.pajama.trackfoodtruck.Adapters;

import com.example.pajama.trackfoodtruck.R;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PhotoViewAdapter extends PagerAdapter
{
	private Context context;
	private int[] GalImages = new int[] { R.drawable.foodtruckimage, R.drawable.foodtruckimage, R.drawable.foodtruckimage };

	public PhotoViewAdapter(Context context)
	{
		this.context = context;
	}

	@Override
	public int getCount()
	{
		return GalImages.length;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position)
	{
		ImageView imageView = new ImageView(context);
		int padding = context.getResources().getDimensionPixelOffset(R.dimen.padding_medium);

		imageView.setPadding(padding, padding, padding, padding);
		imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imageView.setImageResource(GalImages[position]);

		((ViewPager) container).addView(imageView, 0);

		return imageView;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
	{
		((ViewPager) container).removeView((ImageView) object);
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
	{
		return view == ((ImageView) o);
	}

}
