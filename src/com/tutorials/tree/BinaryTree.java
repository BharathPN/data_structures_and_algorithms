package com.tutorials.tree;

import com.tutorials.queue.Queue;

public class BinaryTree {

	private int size;
	private Node root;

	public BinaryTree(Node newRoot) {
		this.root = newRoot;
	}

	public BinaryTree() {
	}

	public void add(int data) {
		Node n = new Node(data);
		if (root == null) {
			root = n;
			size++;
		} else {
			Queue<Node> queue = new Queue<Node>();
			Node tmp = root;
			queue.enqueue(tmp);
			while (!queue.isEmpty()) {
				tmp = queue.dequeue();
				if (tmp.getLeft() == null) {
					tmp.setLeft(n);
					size++;
					return;
				} else {
					queue.enqueue(tmp.getLeft());
				}
				if (tmp.getRight() == null) {
					tmp.setRight(n);
					size++;
					return;
				} else {
					queue.enqueue(tmp.getRight());
				}
			}
		}
	}

	public void levelOrderTraversal() {
		Queue<Node> queue = new Queue<Node>();
		Node tmp = root;
		queue.enqueue(tmp);
		while (!queue.isEmpty()) {
			tmp = queue.dequeue();
			System.out.print(tmp.getData() + " ");
			if (tmp.getLeft() != null) {
				queue.enqueue(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.enqueue(tmp.getRight());
			}
		}
	}

	public void preOrderTraversal(Node node) {
		if (node == null) {
			return;
		} else {
			// visiting the root node
			System.out.print(node.getData() + " ");

			// traversal of left sub tree
			preOrderTraversal(node.getLeft());

			// traversal of right sub tree
			preOrderTraversal(node.getRight());
		}
	}

	public void inOrderTraversal(Node node) {
		if (node == null) {
			return;
		} else {
			// traversal of left sub tree
			inOrderTraversal(node.getLeft());

			// visiting the root node
			System.out.print(node.getData() + " ");

			// traversal of right sub tree
			inOrderTraversal(node.getRight());
		}
	}

	public void postOrderTraversal(Node node) {
		if (node == null) {
			return;
		} else {
			// traversal of left sub tree
			postOrderTraversal(node.getLeft());

			// traversal of right sub tree
			postOrderTraversal(node.getRight());

			// visiting the root node
			System.out.print(node.getData() + " ");
		}
	}

	public void printLeaves(Node node) {
		if (node == null) {
			return;
		} else {
			if (isLeaf(node)) {
				System.out.print(node.getData() + " ");
				return;
			}

			// traversal of left sub tree
			printLeaves(node.getLeft());

			// traversal of right sub tree
			printLeaves(node.getRight());
		}
	}

	public void deleteAllOccurances() {
		deleteNode(root);
		root = null;
	}

	private void deleteNode(Node node) {
		if (node == null) {
			return;
		} else {
			deleteNode(node.getLeft());

			deleteNode(node.getRight());

			if (node.getLeft() != null) {
				node.setLeft(null);
			}
			if (node.getRight() != null) {
				node.setRight(null);
			}
		}
	}

	public void printBoundry() {
		printLeft(root);
		printLeaves(root);
		printRight(root.getRight());
	}

	private void printRight(Node node) {
		if (node == null) {
			return;
		} else if (isLeaf(node)) {
			return;
		} else {
			printRight(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	private void printLeft(Node node) {
		if (node == null) {
			return;
		} else if (isLeaf(node)) {
			return;
		} else {
			System.out.print(node.getData() + " ");
			printLeft(node.getLeft());
		}
	}

	public int getMax() {
		return getMax(root);
	}

	private int getMax(Node node) {
		if (node == null) {
			return 0;
		} else {
			int a = getMax(node.getLeft());
			int b = getMax(node.getRight());
			return Math.max(node.getData(), Math.max(a, b));
		}
	}

	private boolean isLeaf(Node node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public int getSize() {
		return getSize(root);
	}

	private int getSize(Node node) {
		if (node == null) {
			return 0;
		} else {
			return getSize(node.getLeft()) + getSize(node.getRight()) + 1;
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else if (isLeaf(node)) {
			return 0;
		} else {
			return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
		}
	}

	public BinaryTree clone() {
		Node newRoot = createNewTree(root);
		return new BinaryTree(newRoot);
	}

	private Node createNewTree(Node node) {
		if (node == null) {
			return null;
		} else {
			Node newNode = new Node(node.getData());

			Node left = createNewTree(node.getLeft());
			Node right = createNewTree(node.getRight());

			newNode.setLeft(left);
			newNode.setRight(right);
			return newNode;
		}
	}

	public int getDiameter() {
		DiaHeight diaHeight = new DiaHeight(0, 0);
		DiaHeight dh = getDiameter(root, diaHeight);
		return dh.getDiameter();
	}

	private DiaHeight getDiameter(Node root, DiaHeight diaHeight) {
		if (root == null) {
			return diaHeight;
		} else {
			DiaHeight left = getDiameter(root.getLeft(), diaHeight);
			DiaHeight right = getDiameter(root.getRight(), diaHeight);

			int curDia = left.getHeight() + right.getHeight() + 1;
			diaHeight.setDiameter(Math.max(curDia, Math.max(left.getDiameter(), right.getDiameter())));
			diaHeight.setHeight(1 + Math.max(left.getHeight(), right.getHeight()));
			return diaHeight;
		}
	}
}
