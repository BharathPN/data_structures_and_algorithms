package com.tutorials.divideandconquor;

public class Search {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
		System.out.println(search(arr, 11));
	}

	private static int search(int[] arr, int data) {
		return search(arr, 0, arr.length - 1, data);
	}

	private static int search(int[] arr, int low, int high, int data) {
		if (low > high) {
			return -1;			
		} else {
			int mid = (low + high) >> 1;
			if (arr[mid] == data) {
				return data;
			} else if (data < arr[mid]) {
				return search(arr, low, mid - 1, data);
			} else {
				return search(arr, mid + 1, high, data);
			}
		}
	}
}
