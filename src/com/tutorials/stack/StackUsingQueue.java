package com.tutorials.stack;

import com.tutorials.queue.Queue;

public class StackUsingQueue<T> {

	private Queue<T> queue1 = new Queue<T>();
	private Queue<T> queue2 = new Queue<T>();
	private int size;

	public void push(T data) {
		queue1.enqueue(data);
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			return null;
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
