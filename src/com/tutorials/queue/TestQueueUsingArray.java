package com.tutorials.queue;

public class TestQueueUsingArray {

	public static void main(String[] args) {
		QueueUsingArray queueUsingArray = new QueueUsingArray(5);
		System.out.println(queueUsingArray.dequeue());
		queueUsingArray.enqueue(40);
		queueUsingArray.enqueue(50);
		queueUsingArray.enqueue(60);
		queueUsingArray.enqueue(10);
		queueUsingArray.enqueue(20);
		
		System.out.println(queueUsingArray.dequeue());
		System.out.println(queueUsingArray.dequeue());
		System.out.println(queueUsingArray.dequeue());
		queueUsingArray.enqueue(30);
		queueUsingArray.enqueue(70);
		System.out.println(queueUsingArray.dequeue());
		System.out.println(queueUsingArray.dequeue());
		System.out.println(queueUsingArray.dequeue());
		System.out.println(queueUsingArray.dequeue());
		
	}
}
