package com.tutorials.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 25, 30, 19, 13, 7, 15, 11 };
		arr = quickSort(arr);
		for (int data : arr) {
			System.out.print(data + " ");
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
		
		int randPI = ((start) + ((int)((Math.random()*(end-start+1)))));
		//Swap a[low] and a[randPI]
		if(end != randPI) {
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
