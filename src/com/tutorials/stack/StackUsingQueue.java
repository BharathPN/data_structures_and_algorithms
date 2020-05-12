package com.tutorials.stack;

import com.tutorials.queue.Queue;

public class StackUsingQueue {

	private Queue queue1 = new Queue();
	private Queue queue2 = new Queue();
	private int size;

	public void push(int data) {
		queue1.enqueue(data);
		size++;
	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			if (queue2.isEmpty()) {
				while (!queue1.isEmpty()) {
					queue2.enqueue(queue1.dequeue());
				}
			}
			size--;
			return queue2.dequeue();
		}
	}

	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

	public int getSize() {
		return size;
	}
}
