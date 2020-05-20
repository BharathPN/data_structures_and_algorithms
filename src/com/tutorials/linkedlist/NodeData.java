package com.tutorials.linkedlist;

public class NodeData<T> {

	private Node<T> node;
	private int carry;

	public NodeData(Node<T> node, int i) {
		this.node = node;
		this.carry = i;
	}

	public Node<T> getNode() {
		return node;
	}

	public void setNode(Node<T> node) {
		this.node = node;
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}

}
