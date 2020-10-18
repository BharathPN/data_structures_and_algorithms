package com.tutorials.linkedlist;

public class SumOfTwoLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(4);
		list1.add(5);
		list1.add(8);
		list1.add(6);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(5);
		list2.add(8);
		list2.add(4);
		list2.add(7);
		LinkedList<Integer> result = addLists(list1, list2);
		result.traverse();
	}

	private static LinkedList<Integer> addLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		NodeData<Integer> nodeData = addSingleDigitNode(list1.getHead(), list2.getHead());
		if (nodeData.getCarry() == 1) {
			Node<Integer> node = new Node<Integer>(nodeData.getCarry());
			node.setNext(nodeData.getNode());
			return new LinkedList<Integer>(node);
		} else {
			return new LinkedList<Integer>(nodeData.getNode());
		}
	}

	private static NodeData<Integer> addSingleDigitNode(Node<Integer> node1, Node<Integer> node2) {
		if (node1 == null && node2 == null) {
			return new NodeData<Integer>(null, 0);
		} else {
			NodeData<Integer> nodeData = addSingleDigitNode(node1.getNext(), node2.getNext());
			int val = node1.getData() + node2.getData() + nodeData.getCarry();
			Node<Integer> node = new Node<Integer>(val % 10);
			node.setNext(nodeData.getNode());
			
			nodeData.setNode(node);
			nodeData.setCarry(val / 10);
			return nodeData;
		}
	}
}
