package com.tutorials.doubllinkedlist;

public class TestDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.add(10);
		doublyLinkedList.add(20);
		doublyLinkedList.add(30);
		doublyLinkedList.add(40);
		doublyLinkedList.reverse();
		doublyLinkedList.traverse();
	}
}
