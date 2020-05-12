package com.tutorials.linkedlist;

public class Test {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(4);
		list1.add(5);
		list1.add(8);
		list1.add(6);
		LinkedList list2 = new LinkedList();
		list2.add(8);
		list2.add(7);
		list2.add(4);
		list2.add(5);
		LinkedList result = addLists(list1, list2);
		result.traverse();
	}

	private static LinkedList addLists(LinkedList list1, LinkedList list2) {
		NodeData nodeData = addSingleDigitNode(list1.getHead(), list2.getHead());
		if (nodeData.getCarry() == 1) {
			Node node = new Node(nodeData.getCarry());
			node.setNext(nodeData.getNode());
			return new LinkedList(node);
		} else {
			return new LinkedList(nodeData.getNode());
		}
	}

	private static NodeData addSingleDigitNode(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return new NodeData(null, 0);
		} else {
			NodeData nodeData = addSingleDigitNode(node1.getNext(), node2.getNext());
			int val = node1.getData() + node2.getData() + nodeData.getCarry();
			Node node = new Node(val % 10);
			node.setNext(nodeData.getNode());
			
			nodeData.setNode(node);
			nodeData.setCarry(val / 10);
			return nodeData;
		}
	}
}
