package com.tutorials.divideandconquor;

public class FindLastOccurance {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5,
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 };
		System.out.println(findLastOccuranceOf(1, arr, 0, arr.length - 1));
		System.out.println(findLastOccuranceOfUsingIterative(1, arr, 0, arr.length - 1));
	}

	private static int findLastOccuranceOf(int data, int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = low + high >> 1;
			if ((high == mid && arr[mid] == data) || (arr[mid] == data && arr[mid + 1] > arr[mid])) {
				return mid;
			} else if (arr[mid] > data) {
				return findLastOccuranceOf(data, arr, low, mid - 1);
			} else if (arr[mid] <= data) {
				return findLastOccuranceOf(data, arr, mid + 1, high);
			} else {
				return -1;
			}
		}
	}

	private static int findLastOccuranceOfUsingIterative(int data, int[] arr, int low, int high) {
		while (low <= high) {
			int mid = low + high >> 1;
			if ((high == mid && arr[mid] == data) || (arr[mid] == data && arr[mid + 1] > arr[mid])) {
				return mid;
			} else if (arr[mid] > data) {
				return findLastOccuranceOf(data, arr, low, mid - 1);
			} else if (arr[mid] <= data) {
				return findLastOccuranceOf(data, arr, mid + 1, high);
			} else {
				return -1;
			}
		}
		return -1;
	}

}
