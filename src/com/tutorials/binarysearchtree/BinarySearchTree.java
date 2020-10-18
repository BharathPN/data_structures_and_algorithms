package com.tutorials.binarysearchtree;

public class BinarySearchTree {

	private Node root;
	int size;
	private int prev;
	private int count;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			Node n = new Node(data);
			return n;
		} else {
			if (data < root.getData()) {
				Node left = insert(root.getLeft(), data);
				root.setLeft(left);
			} else {
				Node right = insert(root.getRight(), data);
				root.setRight(right);
			}
			return root;
		}
	}

	public boolean contains(int data) {
		return contains(root, data);
	}

	private boolean contains(Node root, int data) {
		if (root == null) {
			return false;
		} else if (root.getData() == data) {
			return true;
		} else {
			if (data < root.getData()) {
				boolean left = contains(root.getLeft(), data);
				return left;
			} else {
				boolean right = contains(root.getRight(), data);
				return right;
			}
		}
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) {
		if (root == null) {
			return null;
		} else if (root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data));
			return root;
		} else if (root.getData() < data) {
			root.setRight(delete(root.getRight(), data));
			return root;
		} else {
			if (isLeaf(root)) {
				return null;
			} else if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				Node maxLeft = findMax(root.getLeft());
				root.setData(maxLeft.getData());
				root.setLeft(delete(root.getLeft(), maxLeft.getData()));
				return root;
			}
		}
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node root) {
		if (root == null) {
			return true;
		} else {
			boolean left = isBST(root.getLeft());
			if (!left) {
				return left;
			}

			if (prev > root.getData()) {
				return false;
			} else {
				prev = root.getData();
			}

			boolean right = isBST(root.getRight());
			return right;
		}
	}

	private Node findMax(Node node) {
		if (node == null) {
			return null;
		} else if (node.getRight() == null) {
			return node;
		} else {
			return findMax(node.getRight());
		}
	}

	public void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		} else {
			inOrder(root.getLeft());

			System.out.print(root.getData() + " ");

			inOrder(root.getRight());
		}
	}

	private boolean isLeaf(Node node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public int findKthSmallestElement(int k) {
		count = 0;
		return findKthSmallestElement(root, k);
	}

	private int findKthSmallestElement(Node root, int k) {
		if (root == null) {
			return -1;
		} else {
			int left = findKthSmallestElement(root.getLeft(), k);
			if (left != -1) {
				return left;
			}
			if (count == k) {
				return root.getData();
			} else {
				count++;
			}

			int right = findKthSmallestElement(root.getRight(), k);
			return right;
		}
	}

}
