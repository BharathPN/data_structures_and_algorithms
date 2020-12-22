package com.tutorials.sorting;

public class SortingUtil {

	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;

		for (int comp = (n - 1); comp > 0; --comp) {
			for (int i = 0; i < comp; i++) {
				if (arr[i] > arr[i + 1]) {
					// swapping logic
					arr[i] = arr[i] ^ arr[i + 1];
					arr[i + 1] = arr[i] ^ arr[i + 1];
					arr[i] = arr[i] ^ arr[i + 1];
				}
			}
		}
		return arr;
	}

	public static int[] selectionSort(int[] arr) {
		int n = arr.length;

		for (int index = 0; index < n - 1; index++) {
			int min = index;
			for (int j = index + 1; j < n; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != index) {
				// swapping logic
				arr[index] = arr[index] ^ arr[min];
				arr[min] = arr[index] ^ arr[min];
				arr[index] = arr[index] ^ arr[min];
			}
		}

		return arr;
	}

	public static int[] insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int hole = i;
			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
		return arr;
	}

	public static int[] mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}

	private static void mergeSort(int[] arr, int low, int high) {
		int[] temp = new int[(high - low) + 1];
		mergeSort(arr, low, high, temp);
	}

	private static void mergeSort(int[] arr, int low, int high, int[] temp) {
		int mid;
		if (low >= high) {
			return;

		} else {
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

	public static int[] quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {

		int randPI = ((start) + ((int) ((Math.random() * (end - start + 1)))));
		// Swap a[low] and a[randPI]
		if (end != randPI) {
			arr[end] ^= arr[randPI];
			arr[randPI] ^= arr[end];
			arr[end] ^= arr[randPI];
		}

		int pivot = arr[end];
		int partitionIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, end);
		return partitionIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}
}
