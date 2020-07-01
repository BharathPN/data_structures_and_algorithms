package com.tutorials.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 25, 30, 19, 13, 7, 15, 11, 20 };
		mergeSort(arr, 0, arr.length - 1);
		for (int data : arr) {
			System.out.print(data + " ");
		}
	}

	public static void mergeSort(int[] arr, int low, int high) {
		int[] temp = new int[(high - low) + 1];
		mergeSort(arr, low, high, temp);
	}

	private static void mergeSort(int[] arr, int low, int high, int[] temp) {
		// int[] temp = new int[20];
		int mid;
		if (low >= high)
			return;
		else {
			mid = (low + high) >> 1;
			mergeSort(arr, low, mid, temp);
			mergeSort(arr, mid + 1, high, temp);
			merge(arr, low, mid, high, temp);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && (j <= high)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= high) {
			temp[k++] = arr[j++];
		}
		// copy back to original array
		for (i = low; i <= high; i++) {
			arr[i] = temp[i];
		}
	}

}
