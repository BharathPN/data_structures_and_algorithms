package com.tutorials.queue;

public class Queue<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public void enqueue(T data) {
		Node<T> n = new Node<T>(data);
		if (front == null && rear == null) {
			front = rear = n;
			size++;
		} else {
			rear.setNext(n);
			rear = n;
			size++;
		}
	}
	
	public T dequeue() {
		if (front == null) {
			 return null;
		} else {
			Node<T> tmp = front;
			if (front == rear) {
				front = rear = null;
			} else {
				front = tmp.getNext();
				tmp.setNext(null);				
			}
			--size;
			return tmp.getData();
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return front == null && rear == null;
	}
}
