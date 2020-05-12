package com.tutorials.stack;

public class Stack {

	private int size;
	private Node top;
	
	public void push(int data) {
		Node n = new Node(data);
		if (top == null) {
			top = n;
			size++;
		} else {
			n.setNext(top);
			top = n;
			size++;
		}
	}
	
	public int pop() {
		if (top == null) {
			return -1;
		} else {
			Node tmp = top;
			top = top.getNext();
			tmp.setNext(null);
			--size;
			return tmp.getData();
		}
	}
	
	public int peek() {
		if (top == null) {
			return -1;
		} else {
			return top.getData();
		}
	}
	
	public int size() {
		return size;
	}
}
