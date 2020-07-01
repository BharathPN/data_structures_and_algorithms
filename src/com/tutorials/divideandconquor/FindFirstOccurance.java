package com.tutorials.divideandconquor;

public class FindFirstOccurance {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5,
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 };
		System.out.println(findFirstOccuranceOf(6, arr, 0, arr.length - 1));
		System.out.println(findFirstOccuranceOfUsingIterative(6, arr, 0, arr.length - 1));
	}

	private static int findFirstOccuranceOf(int data, int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = low + high >> 1;
			if ((low == mid && arr[mid] == data) || (arr[mid] == data && arr[mid-1] < arr[mid])) {
				return mid;
			} else if (arr[mid] >= data) {
				return findFirstOccuranceOf(data, arr, low, mid - 1);
			} else if (arr[mid] < data) {
				return findFirstOccuranceOf(data, arr, mid + 1, high);
			} else {
				return -1;
			}
		}
	}
	
	private static int findFirstOccuranceOfUsingIterative(int data, int[] arr, int low, int high) {
		while (low <= high) {
			int mid = low + high >> 1;
			if ((low == mid && arr[mid] == data) || (arr[mid] == data && arr[mid-1] < arr[mid])) {
				return mid;
			} else if (arr[mid] >= data) {
				high = mid -1;
			} else if (arr[mid] < data) {
				low = mid + 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
}
