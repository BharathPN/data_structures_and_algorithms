package com.tutorials.queue;

import java.util.Stack;

public class QueueUsingStack {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	private int size;

	public void enqueue(Integer data) {
		stack1.push(data);
		size++;
	}

	public int dequeue() {
		if (isEmpty()) {
			return -1;
		}
		else if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		size--;
		return stack2.pop();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public int getSize() {
		return size;
	}

}
