package com.walmart.pojo;

import java.util.List;

public class ReviewResults {

	private List<ReviewStatistics> reviewStatistics;
	private int itemId;
	private String name;
	private float salePrice;
	private String categoryPath;
	private String brandName;
	
	public List<ReviewStatistics> getReviewStatistics() {
		return reviewStatistics;
	}

	public void setReviewStatistics(List<ReviewStatistics> reviewStatistics) {
		this.reviewStatistics = reviewStatistics;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}