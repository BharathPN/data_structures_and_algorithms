package com.tutorials.linkedlist;

public class Test {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
//		linkedList.add(4);
//		linkedList.add(2);
//		linkedList.add(3);
//		linkedList.add(5);
//		linkedList.add(8);
//		linkedList.add(6);

//		linkedList.traverse();

//		linkedList.delete(1);
//		System.out.println();
		linkedList.traverse();

//		System.out.println();
//		System.out.println("Middle element is : " + linkedList.findMiddle());
//
//		linkedList.findKthElement(7);
		
//		linkedList.findEvenOrOdd();
//		linkedList.printReverse();
//		linkedList.reverseLinkedList();
//		linkedList.traverse();
		
//		linkedList.add(4);
		linkedList.insertInAscending(3);
		linkedList.insertInAscending(1);
		linkedList.insertInAscending(2);
		linkedList.insertInAscending(3);
		linkedList.insertInAscending(5);
		linkedList.insertInAscending(8);
		linkedList.insertInAscending(6);
		linkedList.insertInAscending(4);
		linkedList.traverse();
		System.out.printf("%nsize : %d%n", linkedList.size());
		linkedList.deleteAllOccurences();
		System.out.printf("size : %d%n", linkedList.size());
	}
}
