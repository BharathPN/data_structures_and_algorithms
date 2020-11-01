package com.tutorials.array;

// Question : Maximum and minimum of an array using minimum number of comparisons
public class MaxAndMinOfAnArray {

	static class Pair {
		int min;
		int max;
	}

	public static void main(String[] args) {

		Pair pair;
		int[] arr1 = { 5, 1, 3, 2, 4 };
		int[] arr2 = { 6, 5, 1, 3, 2, 4 };

		pair = getMinAndMax1(arr1);
		printPair(pair);
		pair = getMinAndMax1(arr2);
		printPair(pair);

		pair = getMinAndMax2(arr1, 0, arr1.length - 1);
		printPair(pair);
		pair = getMinAndMax2(arr2, 0, arr2.length - 1);
		printPair(pair);
		
		pair = getMinAndMax3(arr1);
		printPair(pair);
		pair = getMinAndMax3(arr2);
		printPair(pair);

	}

	private static Pair getMinAndMax3(int[] arr1) {
		
		return null;
	}

	/*
	 * Since it is recursive solution (Divide and Conquer)
	 * Time Complexity : O(n/2) Space Complexity : O(2)
	 */
	private static Pair getMinAndMax2(int[] arr, int low, int high) {
		Pair pair, mml, mmr;
		pair = new Pair();
		if (low >= high) {
			pair.min = arr[low];
			pair.max = arr[low];
			return pair;
		} else if (low + 1 == high) {
			if (arr[low] > arr[high]) {
				pair.min = arr[high];
				pair.max = arr[low];
			} else {
				pair.max = arr[high];
				pair.min = arr[low];
			}
			return pair;
		} else {
			int mid = (low + high) / 2;

			mml = getMinAndMax2(arr, low, mid);
			mmr = getMinAndMax2(arr, mid + 1, high);

			if (mml.min < mmr.min) {
				pair.min = mml.min;
			} else {
				pair.min = mmr.min;
			}

			if (mml.max > mmr.max) {
				pair.max = mml.max;
			} else {
				pair.max = mmr.max;
			}
			return pair;
		}
	}

	/*
	 * Since we have to linearly traverse through all the elements Total Time
	 * Complexity : O(n) Space Complexity : O(1)
	 */
	private static Pair getMinAndMax1(int[] arr) {
		Pair pair = new Pair();

		if (arr.length == 1) {
			pair.min = arr[0];
			pair.max = arr[0];
		} else {
			if (arr[0] > arr[1]) {
				pair.max = arr[0];
				pair.min = arr[1];
			} else {
				pair.max = arr[1];
				pair.min = arr[0];
			}

			for (int i = 2; i < arr.length; i++) {
				if (pair.min > arr[i]) {
					pair.min = arr[i];
				}
				if (arr[i] > pair.max) {
					pair.max = arr[i];
				}
			}
		}
		return pair;
	}

	private static void printPair(Pair pair) {
		System.out.printf("Min : %s%n", pair.min);
		System.out.printf("Max : %s%n", pair.max);
	}

}
