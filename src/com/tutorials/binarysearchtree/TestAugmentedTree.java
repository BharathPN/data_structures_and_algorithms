package com.tutorials.binarysearchtree;

public class TestAugmentedTree {

	public static void main(String[] args) {
		AugmentedBinarySearchTree tree = new AugmentedBinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(60);
		tree.insert(40);
		tree.insert(15);
		tree.insert(90);
		
		tree.inOrderTraversal();
		System.out.println();
		System.out.println(tree.findKthLargestElement(0));
		System.out.println(tree.findKthLargestElement(1));
		System.out.println(tree.findKthLargestElement(2));
		System.out.println(tree.findKthLargestElement(3));
		System.out.println(tree.findKthLargestElement(3));
		System.out.println(tree.findKthLargestElement(4));
		System.out.println(tree.findKthLargestElement(5));
	}
}
