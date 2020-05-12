package com.tutorials.queue;

public class TestQueueUsingStack {

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		System.out.println(queue.dequeue());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
