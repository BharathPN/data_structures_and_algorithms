package com.tutorials.binarysearchtree;

public class AugmentedBinarySearchTree {

	private AugmentedNode root;
	int size;
	private int prev;

	public void insert(int data) {
		root = insert(root, data);
	}

	private AugmentedNode insert(AugmentedNode root, int data) {
		if (root == null) {
			AugmentedNode n = new AugmentedNode(data);
			root = n;
		} else {
			if (data < root.getData()) {
				AugmentedNode left = insert(root.getLeft(), data);
				root.setLeft(left);
			} else {
				AugmentedNode right = insert(root.getRight(), data);
				root.setRight(right);
			}
		}
		root.setSize(size(root.getLeft()) + size(root.getRight()) + 1);
		return root;
	}

	private int size(AugmentedNode node) {
		if (node == null) {
			return 0;
		}
		return node.getSize();
	}

	public boolean contains(int data) {
		return contains(root, data);
	}

	private boolean contains(AugmentedNode root, int data) {
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

	private AugmentedNode delete(AugmentedNode root, int data) {
		if (root == null) {
			root = null;
		} else if (root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data));
		} else if (root.getData() < data) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if (isLeaf(root)) {
				root = null;
			} else if (root.getLeft() == null) {
				root = root.getRight();
			} else if (root.getRight() == null) {
				root = root.getLeft();
			} else {
				AugmentedNode maxLeft = findMax(root.getLeft());
				root.setData(maxLeft.getData());
				root.setLeft(delete(root.getLeft(), maxLeft.getData()));
			}
		}
		if (root != null) {
			root.setSize(size(root.getLeft()) + size(root.getRight()) + 1);
		}
		return root;
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(AugmentedNode root) {
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

	private AugmentedNode findMax(AugmentedNode AugmentedNode) {
		if (AugmentedNode == null) {
			return null;
		} else if (AugmentedNode.getRight() == null) {
			return AugmentedNode;
		} else {
			return findMax(AugmentedNode.getRight());
		}
	}

	public void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(AugmentedNode root) {
		if (root == null) {
			return;
		} else {
			inOrder(root.getLeft());

			System.out.print(root.getData() + " ");

			inOrder(root.getRight());
		}
	}

	private boolean isLeaf(AugmentedNode AugmentedNode) {
		return AugmentedNode.getLeft() == null && AugmentedNode.getRight() == null;
	}

	public int findKthLargestElement(int k) {
		return findKthLargestElement(root, k);
	}

	private int findKthLargestElement(AugmentedNode root, int k) {
		if (root == null) {
			return -1;
		} else {
			int r = size(root.getLeft()) + 1;
			if (k == r) {
				return root.getData();
			} else if (k < r) {
				return findKthLargestElement(root.getLeft(), k);
			} else {
				return findKthLargestElement(root.getRight(), k - r);
			}
		}
	}
}
