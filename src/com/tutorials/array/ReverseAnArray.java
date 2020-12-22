package com.tutorials.array;

//Question : Write a program to reverse an array or string
public class ReverseAnArray {

	public static void main(String[] args) {
		int[] arr1 = { 5, 4, 3, 2, 1 };
		int[] arr2 = { 6, 5, 4, 3, 2, 1 };

		reverse1(arr1);
		print(arr1);
		reverse1(arr2);
		print(arr2);

		reverse2(arr1);
		print(arr1);
		reverse2(arr2);
		print(arr2);

	}

	/*
	 * Reverse approach 1 Time Complexity : O(n) Space Complexity : O(n)
	 */
	private static void reverse1(int[] arr1) {
		int[] arr = new int[arr1.length];
		for (int i = arr1.length - 1; i >= 0; i--) {
			arr[arr.length - 1 - i] = arr1[i];
		}
		arr1 = arr;
	}

	/*
	 * Reverse approach 2 Time Complexity : O(n/2) Space Complexity : O(1)
	 */
	private static void reverse2(int[] arr1) {
		int mid = arr1.length / 2;
		for (int i = 0; i < mid; i++) {
			swap(arr1[i], arr1[arr1.length - 1 - i]);
		}

	}

	private static void swap(int i, int j) {
		i = i ^ j;
		j = i ^ j;
		i = i ^ j;
	}

	private static void print(int[] arr1) {
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
	}

}
