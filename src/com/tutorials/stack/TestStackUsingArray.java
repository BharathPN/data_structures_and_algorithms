package com.tutorials.stack;

public class TestStackUsingArray {

	public static void main(String[] args) {
		StackUsingArray stackUsingArray = new StackUsingArray(5);
//		System.out.println(stackUsingArray.pop());
		stackUsingArray.push(10);
		stackUsingArray.push(20);
		stackUsingArray.push(30);
		stackUsingArray.push(40);
		stackUsingArray.push(50);
		stackUsingArray.push(10);
		System.out.println(stackUsingArray.pop());
		System.out.println(stackUsingArray.pop());
		System.out.println(stackUsingArray.pop());
		System.out.println(stackUsingArray.pop());
		System.out.println(stackUsingArray.pop());
//		System.out.println(stackUsingArray.pop());
	}
}
