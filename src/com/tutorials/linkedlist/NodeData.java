package com.tutorials.linkedlist;

public class NodeData {

	private Node node;
	private int carry;

	public NodeData(Node node, int i) {
		this.node = node;
		this.carry = i;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}

}
