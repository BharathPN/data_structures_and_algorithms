package com.tutorials.combinatorials;

public class Combinatorics {
	static int count;

	public static void binarySequenceGen(int n) {
		int[] array = new int[n];
		binarySequenceGen(array, n);
	}

	private static void binarySequenceGen(int[] array, int n) {
		if (n == 0)
			printArray(array);
		else {
			array[n - 1] = 0;
			binarySequenceGen(array, n - 1);
			array[n - 1] = 1;
			binarySequenceGen(array, n - 1);
		}

	}

	private static void printArray(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}

	public static void kSequenceGen(int k, int n) {
		int[] array = new int[n];
		kSequenceGen(array, k, n);
	}

	private static void kSequenceGen(int[] array, int k, int n) {
		if (n == 0) {
			printArray(array);
		} else {
			for (int i = 0; i < k; i++) {
				array[n - 1] = i;
				kSequenceGen(array, k, n - 1);
			}
		}
	}

	// Permutation of given symbols
	public static void permutations(String str) {
		count = 0;
		permutations("", str);
	}

	private static void permutations(String prefix, String str) {

		int len = str.length();
		if (str.length() == 0) {
			count++;
			System.out.println("count : " + count + " " + prefix);
			return;
		} else {
			for (int i = 0; i < len; i++) {
				permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
			}
		}

	}

	public static void combinations(String str) {
		count = 0;
		combinations("", str);
	}

	private static void combinations(String prefix, String str) {
		// int len = str.length();
		if (str.length() == 0) {
			count++;
			System.out.println("count : " + count + " " + prefix);
			return;
		} else {
			count++;
			System.out.println("count : " + count + " " + prefix);
			for (int i = 0; i < str.length(); i++) {
				combinations(prefix + str.charAt(i), str.substring(i + 1));
			}
		}

	}

	public static void combinationsOfFixed(String str, int num) {
		count = 0;
		combinationsOfFixed("", str, num);
	}

	private static void combinationsOfFixed(String prefix, String str, int num) {
		if (prefix.length() == num) {
			count++;
			System.out.println("count : " + count + " " + prefix);
			return;
		} else {
			for (int i = 0; i < str.length(); i++) {
				combinationsOfFixed(prefix + str.charAt(i), str.substring(i + 1), num);
			}
		}
	}

	public static void permutationsFixed(String str, int num) {
		count = 0;
		permutationsFixed("", str, num);

	}

	private static void permutationsFixed(String prefix, String str, int num) {
		if (prefix.length() == num) {
			count++;
			System.out.println("count : " + count + " " + prefix);
			return;
		} else {
			for (int i = 0; i < str.length(); i++) {
				permutationsFixed(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()),
						num);
			}
		}

	}

}