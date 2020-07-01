package com.tutorials.linkedlist;

public class Test {

	public static void main(String[] args) {
		try {
			LinkedList<Integer> linkedList = new LinkedList<Integer>();
			linkedList.add(1);
			linkedList.add(3);
			linkedList.add(6);
			linkedList.add(9);
			linkedList.add(7);
			linkedList.add(4);
			linkedList.add(2);
			linkedList.add(5);
			linkedList.add(8);
			linkedList.printKthElementFromLast(1);
			linkedList.printKthElementFromLast(2);
			linkedList.printKthElementFromLast(3);
			linkedList.printKthElementFromLast(4);
			linkedList.printKthElementFromLast(5);
//			linkedList.createALoop(0);
//			linkedList.findWetherLoopExist();
//			System.out.println(linkedList.findStartingPointOfLoop());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
