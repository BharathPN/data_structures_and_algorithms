package com.tutorials.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {25, 30, 19, 13, 7, 15, 11};
		
		int n = arr.length;
		
		for(int index = 0; index < n - 1; index++) {
			int min = index;
			for(int j = index + 1; j < n; j++) {
				if (arr[min] < arr[j]) {
					min = j;
				}
			}
			// swapping logic
			arr[index] = arr[index] ^ arr[min];
			arr[min] = arr[index] ^ arr[min];
			arr[index] = arr[index] ^ arr[min];
		}
		
		for (int data : arr) {
			System.out.print(data + " ");
		}
	}
}
