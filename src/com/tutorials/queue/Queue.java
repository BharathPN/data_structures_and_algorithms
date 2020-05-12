package com.tutorials.queue;

public class Queue {

	private Node front;
	private Node rear;
	private int size;
	
	public void enqueue(int data) {
		Node n = new Node(data);
		if (front == null && rear == null) {
			front = rear = n;
			size++;
		} else {
			rear.setNext(n);
			rear = n;
			size++;
		}
	}
	
	public int dequeue() {
		if (front == null) {
			 return -1;
		} else {
			Node tmp = front;
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
