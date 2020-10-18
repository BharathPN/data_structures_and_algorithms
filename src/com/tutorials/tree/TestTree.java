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
		tree.add(45);
		tree.add(65);
		tree.add(55);
//		tree.printPaths();
		System.out.println(tree.getMaxDiameterV1());
//		tree.convertToMirror();
//		tree.levelOrderTraversal();

//		BinaryTree tree2 = new BinaryTree();
//		tree2.add(30);
//		tree2.add(2);
//		tree2.add(1);
//		tree2.add(40);
//		tree2.add(60);
//		tree2.add(3);
//		tree2.add(70);
//		BinaryTree tree2 = tree.createMirror();
//		tree2.levelOrderTraversal();
		// System.out.printf("Does tree contains %d = %s", 60, tree.containsV2(60,
		// tree));
//		tree.printAllAnscestors(4);
//		System.out.println(tree.printLevel(30));
//		System.out.println(tree.printLevel(1));
//		System.out.println(tree.printLevel(2));
//		System.out.println(tree.printLevel(70));
//		System.out.println(tree.printLevel(3));
//		System.out.println(tree.printLevel(60));
//		System.out.println(tree.printLevel(40));
//		System.out.println(tree.printLevel(4));
//		System.out.println(tree.printLevel(5));
	}
}
