package com.walmart.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReviewStatistics {

	private float averageOverallRating;
	private float overallRatingRange;
	private int totalReviewCount;
	
	private List<RatingDistribution> ratingDistributions = new ArrayList<RatingDistribution>();
	public float getAverageOverallRating() {
		return averageOverallRating;
	}
	public void setAverageOverallRating(float averageOverallRating) {
		this.averageOverallRating = averageOverallRating;
	}
	public float getOverallRatingRange() {
		return overallRatingRange;
	}
	public void setOverallRatingRange(float overallRatingRange) {
		this.overallRatingRange = overallRatingRange;
	}
	public int getTotalReviewCount() {
		return totalReviewCount;
	}
	public void setTotalReviewCount(int totalReviewCount) {
		this.totalReviewCount = totalReviewCount;
	}
	public List<RatingDistribution> getRatingDistributions() {
		return ratingDistributions;
	}
	public void setRatingDistributions(List<RatingDistribution> ratingDistributions) {
		this.ratingDistributions = ratingDistributions;
	}
	
}