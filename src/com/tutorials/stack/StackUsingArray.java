package com.tutorials.stack;

public class StackUsingArray {

	int size;
	int arr[];
	int top;

	public StackUsingArray(int length) {
		this.top = -1;
		this.arr = new int[length];
	}

	public void push(int data) {
		if (this.isFull()) {
			return;
		} else {
			++top;
			arr[top] = data;
			size++;
		}
	}

	public int pop() {
		if (this.isEmpty()) {
			return -1;
		} else {
			int data = arr[top];
			--top;
			size--;
			return data;
		}
	}

	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == this.arr.length - 1;
	}
}
