package com.tutorials.array;

// Question : Maximum and minimum of an array using minimum number of comparisons
/*
 * Ugliest algorithm is to sort an entire array and take out minimum and maximum elements
 * overall time complexity will be O(nlogn) (for sorting) + O(1) (for getting Min and Max) 
 */

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

		pair = getMinAndMax3(arr1, arr1.length);
		printPair(pair);
		pair = getMinAndMax3(arr2, arr2.length);
		printPair(pair);

	}

	/*
	 * Time Complexity: O(n) In this method, the total number of comparisons is 1 +
	 * 2(n-2) in the worst case and 1 + n – 2 in the best case. In the above
	 * implementation, the worst case occurs when elements are sorted in descending
	 * order and the best case occurs when elements are sorted in ascending order.
	 */
	private static Pair getMinAndMax1(int[] arr) {
		Pair pair = new Pair();

		if (arr == null && arr.length == 0) {
			throw new NullPointerException("Array size is either null or empty");
		}
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

	/*
	 * Time Complexity: O(n)
	 * 
	 * Total number of comparisons: let the number of comparisons be T(n). T(n) can
	 * be written as follows: Algorithmic Paradigm: Divide and Conquer 
	 * T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2 
	 * T(2) = 1 
	 * T(1) = 0
	 * 
	 * T(n) = 2T(n/2) + 2 After solving the above recursion, we get T(n) = 3n/2 -2
	 * Thus, the approach does 3n/2 -2 comparisons if n is a power of 2. And it does
	 * more than 3n/2 -2 comparisons if n is not a power of 2.
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

	private static Pair getMinAndMax3(int[] arr, int n) {
		Pair minmax = new Pair();
		int i;
		/*
		 * If array has even number of elements then initialize the first two elements
		 * as minimum and maximum
		 */
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				minmax.max = arr[0];
				minmax.min = arr[1];
			} else {
				minmax.min = arr[0];
				minmax.max = arr[1];
			}
			i = 2;
			/* set the starting index for loop */
		} /*
			 * If array has odd number of elements then initialize the first element as
			 * minimum and maximum
			 */ else {
			minmax.min = arr[0];
			minmax.max = arr[0];
			i = 1;
			/* set the starting index for loop */
		}

		/*
		 * In the while loop, pick elements in pair and compare the pair with max and
		 * min so far
		 */
		while (i < n - 1) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > minmax.max) {
					minmax.max = arr[i];
				}
				if (arr[i + 1] < minmax.min) {
					minmax.min = arr[i + 1];
				}
			} else {
				if (arr[i + 1] > minmax.max) {
					minmax.max = arr[i + 1];
				}
				if (arr[i] < minmax.min) {
					minmax.min = arr[i];
				}
			}
			/*
			 * Increment the index by 2 as two elements are processed in loop
			 */
			i += 2;
		}

		return minmax;
	}

	private static void printPair(Pair pair) {
		System.out.printf("Min : %s%n", pair.min);
		System.out.printf("Max : %s%n", pair.max);
	}

}
