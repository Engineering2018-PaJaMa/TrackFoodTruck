package com.example.pajama.trackfoodtruck.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpHandler
{

	private static final String TAG = HttpHandler.class.getSimpleName();

	public HttpHandler()
	{
	}

	public String makeServiceCall(String reqUrl)
	{
		String response = "TrackFoodTruck";
		try
		{
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			response = convertStreamToString(in);
		}
		catch (Exception e)
		{
			Log.e(TAG, "Exception: " + e.getMessage() + e);
		}
		return response;
	}

	private String convertStreamToString(InputStream is)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line;
		try
		{
			while ((line = reader.readLine()) != null)
			{
				sb.append(line).append('\n');
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
