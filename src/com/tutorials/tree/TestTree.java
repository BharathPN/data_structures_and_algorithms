package com.tutorials.tree;

public class TestTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(30);
		tree.add(1);
		tree.add(2);
		tree.add(70);
		tree.add(3);
		tree.add(60);
		tree.add(40);
		tree.add(4);
		BinaryTree newTree = tree.clone();
		newTree.levelOrderTraversal();
	}
}
