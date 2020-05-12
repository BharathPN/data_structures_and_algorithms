package com.tutorials.stack;

public class TestStackUsingQueue {

	public static void main(String[] args) {
		StackUsingQueue queue = new StackUsingQueue();
		System.out.println(queue.pop());
		queue.push(10);
		queue.push(20);
		queue.push(30);
		queue.push(40);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
