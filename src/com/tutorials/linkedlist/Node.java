package com.tutorials.linkedlist;

import java.util.Objects;

public class Node<T> {

	private T data;
	private Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return String.format("Node [data=%s, next=%s]", data, next);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		return Objects.equals(data, other.data);
	}

}
