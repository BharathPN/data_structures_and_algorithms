package com.tutorials.array;

import com.tutorials.sorting.SortingUtil;

public class FindKthLargestOrSmallestElement {

	public static void main(String[] args) {

		int arr[] = { 2, 7, 5, 8, 4, 6, 1, 3 };
		int val = findKthLargestElementUsingSorting(arr, 3);
		System.out.println("Val : " + val);
	}

	/*
	 * Obviously any good sorting algorithm would take O(nlogn) time and the finding
	 * the largest one would require O(1)
	 * 
	 * Time Complexity : O(nlogn)
	 */
	private static int findKthLargestElementUsingSorting(int[] arr, int k) {
		arr = SortingUtil.quickSort(arr);

		if (k < arr.length) {
			return arr[k];
		}
		return -1;
	}
}
