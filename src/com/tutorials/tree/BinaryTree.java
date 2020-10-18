package com.tutorials.tree;

import com.tutorials.queue.Queue;

public class BinaryTree {

	int size;
	private Node root;
	int diameter;

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
		if (tmp != null) {
			queue.enqueue(tmp);
		}
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
		System.out.println();
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

//	public void deleteAllOccurances() {
//		deleteNode(root);
//		root = null;
//	}
//
//	private void deleteNode(Node node) {
//		if (node == null) {
//			return;
//		} else {
//			deleteNode(node.getLeft());
//
//			deleteNode(node.getRight());
//
//			if (node.getLeft() != null) {
//				node.setLeft(null);
//			}
//			if (node.getRight() != null) {
//				node.setRight(null);
//			}
//		}
//	}

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
			// size of left sub tree
			int a = getSize(node.getLeft());
			// size of right sub tree
			int b = getSize(node.getRight());

			return a + b + 1;
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
			// height of left sub tree
			int a = getHeight(node.getLeft());

			// height of right sub tree
			int b = getHeight(node.getRight());

			return 1 + Math.max(a, b);
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

	public void deleteTree() {
		deleteTree(root);
		root = null;
	}

	private void deleteTree(Node root) {
		if (root == null) {
			return;
		} else if (isLeaf(root)) {
			return;
		} else {

			deleteTree(root.getLeft());
			deleteTree(root.getRight());

			if (root.getLeft() != null) {
				root.setLeft(null);
			}
			if (root.getRight() != null) {
				root.setRight(null);
			}
			return;
		}
	}

	public boolean contains(int data, BinaryTree tree) {
		return contains(data, tree.root);
	}

	private boolean contains(int data, Node root) {
		if (root == null) {
			return false;
		} else if (root.getData() == data) {
			return true;
		} else {
			boolean left = contains(data, root.getLeft());
			if (left) {
				return left;
			}
			boolean right = contains(data, root.getRight());
			return right;

			// here we are traversing every node in the tree
//			return left || right;
		}
	}

	public boolean containsV2(int data, BinaryTree tree) {
		return containsV2(data, tree.root);
	}

	private boolean containsV2(int data, Node root) {
		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else {
			return containsV2(data, root.left) || containsV2(data, root.right);
		}
	}

	public boolean printAnscetors(int data) {
		return printAnscetors(data, root);
	}

	private boolean printAnscetors(int data, Node root) {
		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else {
			boolean left = printAnscetors(data, root.left);
			if (left) {
				System.out.print(root.data + " ");
				return left;
			}
			boolean right = printAnscetors(data, root.right);
			if (right) {
				System.out.println(root.data + " ");
				return right;
			}
			return right;
		}
	}

	public boolean printAllAnscestors(int data) {
		return printAllAnscestors(data, root);
	}

	private boolean printAllAnscestors(int data, Node root) {
		if (root == null) {
			return false;
		} else if ((root.data == data) || printAllAnscestors(data, root.left) || printAllAnscestors(data, root.right)) {
			if (root.data != data) {
				System.out.print(root.data + " ");
			}
			return true;
		} else {
			return false;
		}
	}

	public int printLevel(int data) {
		return printLevel(data, root);
	}

	private int printLevel(int data, Node root) {
		if (root == null) {
			return -1;
		} else if (root.data == data) {
			return 0;
		} else {
			int left = printLevel(data, root.left);
			if (left >= 0) {
				return left + 1;
			}

			int right = printLevel(data, root.right);
			if (right >= 0) {
				return right + 1;
			}
			return right;
		}
	}

	public boolean equals(BinaryTree tree) {
		return equals(this.root, tree.root);
	}

	private boolean equals(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null ^ root2 == null) {
			return false;
		} else if (root1.data != root2.data) {
			return false;
		} else {
			boolean left = equals(root1.left, root2.left);
			if (!left) {
				return left;
			}
			boolean right = equals(root1.right, root2.right);
			return right;
		}
	}

	public boolean equalsV2(BinaryTree tree) {
		return equalsV2(this.root, tree.root);
	}

	private boolean equalsV2(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null ^ root2 == null) {
			return false;
		} else {
			return ((root1.data == root2.data) && equalsV2(root1.left, root2.left)
					&& equalsV2(root1.right, root2.right));
		}
	}

	public boolean isMirror(BinaryTree tree) {
		return isMirror(this.root, tree.root);
	}

	private boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null ^ root2 == null) {
			return false;
		} else {
			return ((root1.data == root2.data) && isMirror(root1.left, root2.right)
					&& isMirror(root1.right, root2.left));
		}
	}

	public BinaryTree createMirror() {
		Node newRoot = createMirror(root);
		return new BinaryTree(newRoot);
	}

	private Node createMirror(Node root) {
		if (root == null) {
			return null;
		} else {
			Node left = createMirror(root.left);
			Node right = createMirror(root.right);

			Node node = new Node(root.data);
			node.left = right;
			node.right = left;
			return node;
		}
	}

	public void convertToMirror() {
		convertToMirror(root);
	}

	private void convertToMirror(Node root) {
		if (root == null) {
			return;
		} else if (isLeaf(root)) {
			return;
		} else {
			convertToMirror(root.left);
			convertToMirror(root.right);
			Node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			return;
		}
	}

	public void printPaths() {
		int[] arr = new int[getHeight() + 1];
		printPaths(root, arr, 0);
	}

	private void printPaths(Node root, int[] arr, int index) {
		if (root == null) {
			return;
		} else {
			arr[index] = root.data;
			index++;

			if (isLeaf(root)) {
				for (int i = 0; i < index; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
				return;
			} else {
				printPaths(root.left, arr, index);
				printPaths(root.right, arr, index);
			}
		}
	}

	public int getMaxDiameterV1() {
		return getMaxDiameterV1(root);
	}

	private int getMaxDiameterV1(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftDia = getMaxDiameterV1(root.left);
			int rightDia = getMaxDiameterV1(root.right);

			int left = getHeight(root.left) + 1;
			int right = getHeight(root.right) + 1;
			return Math.max(left + right + 1, Math.max(leftDia, rightDia));
		}
	}

	public int getMaxDiameterV2() {
		diameter = 0;
		getMaxDiameterV2(root);
		return diameter;
	}

	private int getMaxDiameterV2(Node root) {
		if (root == null) {
			return 0;
		} else {
			int left = getMaxDiameterV2(root.left);
			int right = getMaxDiameterV2(root.right);

			if (left + right + 1 > diameter) {
				diameter = left + right + 1;
			}
			return Math.max(left, right) + 1;
		}
	}

	public int getMaxDiameterV3() {
		DiaHeight diaHeight = getMaxDiaMeterV3(root);
		return diaHeight.getMaxDia();
	}

	private DiaHeight getMaxDiaMeterV3(Node root) {
		if (root == null) {
			return new DiaHeight(0, 0);
		} else {
			DiaHeight left = getMaxDiaMeterV3(root.left);
			DiaHeight right = getMaxDiaMeterV3(root.right);

			// calculating height of the current position of the node
			int height = 1 + Math.max(left.getHeight(), right.getHeight());

			// calculating maxDia by comparing it with left and right diameters
			int maxDia = Math.max(left.getHeight() + right.getHeight() + 1,
					Math.max(left.getMaxDia(), right.getMaxDia()));

			return new DiaHeight(height, maxDia);
		}
	}
}
