package com.walmart.util;

import java.util.Comparator;

public class ArrayIndexComparator implements Comparator<Integer> {

	private final Float[] ratingArray;
	private final int[] ratingCountArray;

	public ArrayIndexComparator(Float[] ratingArray, int[] ratingCountArray) {
		this.ratingArray = ratingArray;
		this.ratingCountArray = ratingCountArray;
	}

	public Integer[] createIndexArray() {
		Integer[] indexes = new Integer[ratingArray.length];
		for (int i = 0; i < ratingArray.length; i++) {
			indexes[i] = i;
		}
		return indexes;
	}

	@Override
	public int compare(Integer index1, Integer index2) {

		if (ratingArray[index1] == null)
			ratingArray[index1] = (float) 0;
		if (ratingArray[index2] == null)
			ratingArray[index2] = (float) 0;

/*		if (ratingArray[index1] == ratingArray[index2] && ratingCountArray[index1] != 0
				&& ratingCountArray[index2] != 0 && ratingCountArray[index1] != ratingCountArray[index2])
			return compare((Integer) ratingCountArray[index2], (Integer) ratingCountArray[index1]);*/

		return (ratingArray[index2].compareTo(ratingArray[index1]));
	}
}
