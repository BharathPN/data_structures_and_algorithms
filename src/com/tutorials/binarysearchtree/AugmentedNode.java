package com.tutorials.binarysearchtree;

public class AugmentedNode {

	private int data;
	private AugmentedNode left;
	private AugmentedNode right;
	private int size;

	public AugmentedNode(int data, int size) {
		super();
		this.data = data;
		this.size = size;
	}

	public AugmentedNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AugmentedNode getLeft() {
		return left;
	}

	public void setLeft(AugmentedNode left) {
		this.left = left;
	}

	public AugmentedNode getRight() {
		return right;
	}

	public void setRight(AugmentedNode right) {
		this.right = right;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
