package com.tutorials.queue;

public class QueueUsingArray {

	private int size;
	private int front, rear;
	private int[] arr;

	public QueueUsingArray(int length) {
		arr = new int[length];
		front = rear = -1;
	}

	public void enqueue(int data) {
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			front = (front + 1) % arr.length;
		}
		rear = (rear + 1) % arr.length;
		arr[rear] = data;
		size++;
	}

	public int dequeue() {
		if (isEmpty()) {
			return -1;
		} else {
			int data = arr[front];
			arr[front] = 0;
			front = (front + 1) % arr.length;
			size--;
			return data;
		}
	}

	public boolean isEmpty() {
		return rear == -1 && front == -1;
	}

	public boolean isFull() {
		return front == (rear + 1) % arr.length;
	}
	
	public int size() {
		return size;
	}
}
