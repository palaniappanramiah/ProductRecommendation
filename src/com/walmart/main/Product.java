package com.walmart.main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.walmart.pojo.Item;
import com.walmart.pojo.Search;

public class Product extends RankProductRecommendation {

	public int searchProduct(String query) throws IOException {

		address = "https://api.walmartlabs.com/v1/search?apiKey=aez9nzctfy9jsnntzdtq7b2g&query=";
		url = new URL(address + URLEncoder.encode(query, charset));

		reader = new InputStreamReader(url.openStream());
		Search searchResults = gson.fromJson(reader, Search.class);

		reader.close();

		if (searchResults != null && searchResults.getItems() != null)
			return searchResults.getItems().get(0).getItemId();

		return -1;
	}

	public List<Item> searchProductRecommendation(int query) throws IOException {

		address = "https://api.walmartlabs.com/v1/nbp?apiKey=aez9nzctfy9jsnntzdtq7b2g&itemId=";
		url = new URL(address + URLEncoder.encode(Integer.toString(query), charset));

		reader = new InputStreamReader(url.openStream());
		ArrayList<Item> itemResults = new ArrayList<Item>();

		JsonParser parser = new JsonParser();
		JsonArray jArray = parser.parse(reader).getAsJsonArray();

		for (JsonElement obj : jArray) {
			Item item = gson.fromJson(obj, Item.class);
			itemResults.add(item);
		}

		reader.close();

		return itemResults;
	}

}