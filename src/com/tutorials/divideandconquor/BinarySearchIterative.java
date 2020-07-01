package com.tutorials.divideandconquor;

public class BinarySearchIterative {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
		System.out.println(binarySearchIterative(arr, 0, arr.length - 1, 10));
		System.out.println(binarySearchIterative(arr, 0, arr.length - 1, 5));
		System.out.println(binarySearchIterative(arr, 0, arr.length - 1, 50));
		System.out.println(binarySearchIterative(arr, 0, arr.length - 1, 35));
		System.out.println(binarySearchIterative(arr, 0, arr.length - 1, 55));
	}

	private static int binarySearchIterative(int[] arr, int low, int high, int data) {
		while (low <= high) {
			int mid = low + high >> 1;
			if (arr[mid] == data) {
				return data;
			} else if (arr[mid] > data) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
