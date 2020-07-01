package com.tutorials.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 25, 30, 19, 13, 7, 15, 11 };

		insertionSort(arr);

		for (int data : arr) {
			System.out.print(data + " ");
		}
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int hole = i;
			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = value;
		}
	}
}
