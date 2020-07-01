package com.tutorials.divideandconquor;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 2, 1 };
		System.out.println(findPeakElement(arr, 0, arr.length - 1));
	}

	private static int findPeakElement(int[] arr, int low, int high) {
		if (high < low) {
			return -1;
		} else {
			int mid = (low + high) >> 1;
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid  + 1]) {
				return arr[mid];
			} else if (arr[mid - 1] <= arr[mid] && arr[mid] <= arr[mid+1]) {
				return findPeakElement(arr, mid + 1, high);
			} else if (arr[mid - 1] >= arr[mid] && arr[mid] >= arr[mid+1]){
				return findPeakElement(arr, low, mid - 1);
			}
			return -1;
		}
	}
}
