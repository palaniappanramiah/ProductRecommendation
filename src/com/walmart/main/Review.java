package com.walmart.main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.GsonBuilder;
import com.walmart.pojo.ReviewResults;
import com.walmart.util.ArrayAdapterFactory;

public class Review extends RankProductRecommendation {

	private static ReviewResults reviewResults = null;

	@SuppressWarnings("unused")
	private Review() {
	}

	protected Review(int itemId) {
		Review.itemId = itemId;
	}

	@Override
	public void run() {

		address = "https://api.walmartlabs.com/v1/reviews/" + itemId + "?apiKey=aez9nzctfy9jsnntzdtq7b2g&format=json";

		try {
			url = new URL(address);
			reader = new InputStreamReader(url.openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactory()).create();
		reviewResults = gson.fromJson(reader, ReviewResults.class);

		reviewResultsList.add(reviewResults);

	}
}