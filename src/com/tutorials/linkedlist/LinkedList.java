package com.tutorials.linkedlist;

public class LinkedList {

	private int size;
	private Node head;

	void add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			size++;
		} else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			size++;
		}
	}

	void traverse() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

	int size() {
		return size;
	}

	void delete(int data) {
		if (head == null) {
			System.out.println("No Elements are there to delete");
		} else if (head.getData() == data) {
			Node temp = head;
			head = temp.getNext();
			temp.setNext(null);
		} else {
			Node prev = head;
			Node cur = head.getNext();
			while (cur != null) {
				if (cur.getData() == data) {
					prev.setNext(cur.getNext());
					cur.setNext(null);
					return;
				} else {
					prev = prev.getNext();
					cur = cur.getNext();
				}
			}
			if (cur == null) {
				System.out.println();
				System.out.println(data + " is not present");
			}
		}
	}

	int findMiddle() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow.getData();
	}

	void findKthElement(int k) {
		if (k <= 0) {
			System.out.println("Please provide proper value");
		} else {
			Node slow = head;
			Node fast = head;
			int index = 0;
			while (fast != null && index < k - 1) {
				fast = fast.getNext();
				index++;
			}

			if (fast == null) {
				System.out.println(k + " is greater than total number of elements");
				return;
			} else {
				while (fast.getNext() != null) {
					fast = fast.getNext();
					slow = slow.getNext();
				}
				System.out.println("the kth element is " + slow.getData());
				return;
			}
		}
	}

	void findEvenOrOdd() {
		Node fast = head;

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
		}
		if (fast == null) {
			System.out.println("The list is even");
		} else {
			System.out.println("The list is odd");
		}
	}

	void printReverse() {
		printRev(head);
		System.out.println("head : " + head);
	}

	private void printRev(Node head) {
		if (head == null) {
			return;
		} else {
			printRev(head.getNext());
			System.out.print(head.getData() + " ");
		}
	}

	void reverseLinkedList() {
		if (head == null) {
			System.out.println("Please add atleast one element");
			return;
		} else if (head.getNext() == null) {
			System.out.println("Only one element cannot reverse");
		} else if (head.getNext().getNext() == null) {
			Node tmp = head.getNext();
			tmp.setNext(head);
			head.setNext(null);
			head = tmp;
		} else {
			Node prev = head;
			Node cur = head.getNext();
			Node next = head.getNext().getNext();
			while (next != null) {
				cur.setNext(prev);
				prev = cur;
				cur = next;
				next = next.getNext();
			}
			cur.setNext(prev);
			head.setNext(null);
			head = cur;
		}
	}

	void insertInAscending(int data) {
		Node n = new Node(data);
		++size;
		if (head == null) {
			head = n;
			return;
		} else if (head.getData() > n.getData()) {
			n.setNext(head);
			head = n;
			return;
		} else {
			Node tmp = head;
			Node prev = tmp;
			Node cur = null;
			while (tmp != null && tmp.getData() < n.getData()) {
				prev = tmp;
				tmp = tmp.getNext();
				cur = tmp;
			}
			prev.setNext(n);
			n.setNext(cur);
		}
	}
	
	void deleteAllOccurences() {
		deleteNode(head);
	}

	private void deleteNode(Node head) {
		if (head == null) {
			return;
		} else {
			deleteNode(head.getNext());
			--size;
			head.setNext(null);
		}
	}
}
