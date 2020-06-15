package com.tutorials.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {25, 30, 19, 13, 7, 15, 11};
		
		int n = arr.length;

		for(int comp = (n - 1); comp > 0; --comp) {
			for(int i = 0; i < comp; i++) {
				if (arr[i] > arr[i+1]) {
					// swapping logic
					arr[i] = arr[i] ^ arr[i+1];
					arr[i+1] = arr[i] ^ arr[i+1];
					arr[i] = arr[i] ^ arr[i+1];
				}
			}
		}
		for (int data : arr) {
			System.out.print(data + " ");
		}
	}
}
