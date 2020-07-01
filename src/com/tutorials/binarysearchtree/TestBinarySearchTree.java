package com.tutorials.binarysearchtree;

public class TestBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(50);
		binarySearchTree.insert(25);
		binarySearchTree.insert(75);
		binarySearchTree.insert(60);
		binarySearchTree.insert(40);
		binarySearchTree.insert(15);
		binarySearchTree.insert(90);
		
//		System.out.println(binarySearchTree.contains(99));
		binarySearchTree.inOrderTraversal();
		System.out.println();
		System.out.println(binarySearchTree.findKthLargestElement(7));
//		
//		binarySearchTree.delete(50);
//		System.out.println();
//		binarySearchTree.inOrderTraversal();		
//		System.out.println();
//		System.out.println(binarySearchTree.isBST());
		
		
	}
}
