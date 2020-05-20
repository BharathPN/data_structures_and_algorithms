package com.tutorials.stack;

public class Stack<T> {

	private int size;
	private Node<T> top;
	
	public void push(T data) {
		Node<T> n = new Node<T>(data);
		if (top == null) {
			top = n;
			size++;
		} else {
			n.setNext(top);
			top = n;
			size++;
		}
	}
	
	public T pop() {
		if (top == null) {
			return null;
		} else {
			Node<T> tmp = top;
			top = top.getNext();
			tmp.setNext(null);
			--size;
			return tmp.getData();
		}
	}
	
	public T peek() {
		if (top == null) {
			return null;
		} else {
			return top.getData();
		}
	}
	
	public int size() {
		return size;
	}
}
