package com.tutorials.divideandconquor;

public class FindMinimum {

	public static void main(String[] args) {
		int[] arr = { 12, 50, 23, 35, 13, 8, 40, 59, 47, 6, 24, 68 };
		System.out.println(findMin(arr, 0, arr.length - 1));

	}

	private static int findMin(int[] arr, int low, int high) {
		if (low == high) {
			return arr[low];
		} else {
			int mid = low + high >>  1;
			int left = findMin(arr, low, mid);
			int right = findMin(arr, mid + 1, high);
			return Math.min(left, right);
		}
	}
}
