package com.walmart.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.walmart.pojo.Item;
import com.walmart.pojo.ReviewResults;
import com.walmart.util.ArrayIndexComparator;

public class RankProductRecommendation extends Thread {

	protected String address;
	protected URL url;
	protected String charset = "UTF-8";

	protected Reader reader;
	protected Gson gson = new Gson();
	protected static int itemId;

	protected static List<ReviewResults> reviewResultsList = new ArrayList<ReviewResults>();

	protected RankProductRecommendation() {
	}

	public static void main(String args[]) throws IOException, InterruptedException {

		String queryProduct;
		int itemId;
		List<Item> itemList;

		int ratingCount[] = new int[10];
		Float rating[] = new Float[10];

		Review[] rank = new Review[10];
		Product product = new Product();

		System.out.println("Please enter a String to search for a Product:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		queryProduct = br.readLine();
		System.out.println("\nloading...");
		br.close();

		itemId = product.searchProduct(queryProduct);

		if (itemId == -1) {
			System.out.println(
					"\nSorry, This query doesn't return any product. Try another query to get better results.");
			return;
		} else
			itemList = product.searchProductRecommendation(itemId);

		if (itemList == null || itemList.size() == 0) {
			System.out.println(
					"\nSorry, There are no recommendations for this product. Try another product to get the recommendations.");
			return;
		}

		for (int i = 0; i < 10; i++) {
			rank[i] = new Review(itemList.get(i).getItemId());
			rank[i].start();
			Thread.sleep(300);
		}

		System.out.println("\nPlease hold on as we get the recommendations for you...");
		Thread.sleep(3000); //Can be limited to less number

		System.out.println("\nWe are very happy to recommend you the below products,\n");

		for (int i = 0; i < reviewResultsList.size(); i++) {
			if (reviewResultsList != null && reviewResultsList.get(i) != null
					&& reviewResultsList.get(i).getReviewStatistics() != null
					&& reviewResultsList.get(i).getReviewStatistics().get(0) != null) {

				rating[i] = reviewResultsList.get(i).getReviewStatistics().get(0).getAverageOverallRating();
				ratingCount[i] = reviewResultsList.get(i).getReviewStatistics().get(0).getTotalReviewCount();
			}
		}

		ArrayIndexComparator comparator = new ArrayIndexComparator(rating, ratingCount);
		Integer[] indexes = comparator.createIndexArray();
		Arrays.sort(indexes, comparator);

		for (int k : indexes) {

			if (reviewResultsList != null && reviewResultsList.get(k) != null) {
				System.out.print(reviewResultsList.get(k).getName() + " at just "
						+ reviewResultsList.get(k).getSalePrice() + "$");
				if (reviewResultsList.get(k).getBrandName() != null)
					System.out.print(", A(n) " + reviewResultsList.get(k).getBrandName() + " brand");
				System.out.println("\n\tItem ID:" + reviewResultsList.get(k).getItemId() + "\t\tCategory: "
						+ reviewResultsList.get(k).getCategoryPath());
			}

			if (reviewResultsList.get(k).getReviewStatistics() != null
					&& reviewResultsList.get(k).getReviewStatistics().get(0) != null
					&& reviewResultsList.get(k).getReviewStatistics().get(0).getTotalReviewCount() != 0)
				System.out.println("\tRating: "
						+ reviewResultsList.get(k).getReviewStatistics().get(0).getAverageOverallRating()
						+ "\t\t\tReviewed by: "
						+ reviewResultsList.get(k).getReviewStatistics().get(0).getTotalReviewCount() + " member(s)");
			else

				System.out
						.println("\tBe the first one to review this product. Try it for 30 day money back guarantee.");

			System.out.println();
		}

	}
}