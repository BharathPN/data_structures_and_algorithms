package com.tutorials.linkedlist;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	private int size;
	private Node<T> head;

	public LinkedList() {
		super();
	}

	public LinkedList(Node<T> node) {
		this.head = node;
	}

	void add(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			size++;
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			size++;
		}
	}

	void traverse() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

	int size() {
		return size;
	}

	void delete(T data) {
		if (head == null) {
			System.out.println("No Elements are there to delete");
		} else if (head.getData().equals(data)) {
			Node<T> temp = head;
			head = temp.getNext();
			temp.setNext(null);
		} else {
			Node<T> prev = head;
			Node<T> cur = head.getNext();
			while (cur != null) {
				if (cur.getData().equals(data)) {
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

	T findMiddle() {
		Node<T> slow = head;
		Node<T> fast = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow.getData();
	}

	void printKthElementFromLast(int k) {
		if (k <= 0) {
			System.out.println("Please provide proper value");
		} else {
			Node<T> slow = head;
			Node<T> fast = head;
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
		Node<T> fast = head;

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

	private void printRev(Node<T> head) {
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
			Node<T> tmp = head.getNext();
			tmp.setNext(head);
			head.setNext(null);
			head = tmp;
		} else {
			Node<T> prev = head;
			Node<T> cur = head.getNext();
			Node<T> next = head.getNext().getNext();
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

//	void insertInAscending(T data) {
//		Node<T> n = new Node<T>(data);
//		++size;
//		if (head == null) {
//			head = n;
//			return;
//		} else if (head.getData() > n.getData()) {
//			n.setNext(head);
//			head = n;
//			return;
//		} else {
//			Node<T> cur = head;
//			while (cur.getNext() != null && cur.getData() <= n.getData()) {
//				cur = cur.getNext();
//			}
//			n.setNext(cur.getNext());
//			cur.setNext(n);
//		}
//	}

	void deleteAllOccurences() {
		deleteNode(head);
	}

	private void deleteNode(Node<T> head) {
		if (head == null) {
			return;
		} else {
			deleteNode(head.getNext());
			--size;
			head.setNext(null);
		}
	}

	public Node<T> getHead() {
		return head;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>();
	}

	public void createALoop(int pos) {
		Node<T> tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		Node<T> tmp2 = head;
		for (int i = 1; i < pos; i++) {
			tmp2 = tmp2.getNext();
		}
		tmp.setNext(tmp2);
	}

	public void findWetherLoopExist() {
		if (head == null) {
			System.out.println("Loop doesn't exist");
			return;
		} else {
			Node<T> fast = head;
			Node<T> slow = head;
			while (fast != null && fast.getNext() != null) {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
				if (fast == slow) {
					System.out.println("Loop exist");
					return;
				}
			}
			System.out.println("Loop doesn't exist");
			return;
		}
	}

	public T findStartingPointOfLoop() throws Exception {
		if (head == null) {
			throw new Exception("Loop doesn't exist");
		} else {
			Node<T> fast = head;
			Node<T> slow = head;
			while (fast != null && fast.getNext() != null) {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
				if (fast == slow) {
					slow = head;
					while (fast != slow) {
						fast = fast.getNext();
						slow = slow.getNext();
					}
					return fast.getData();
				}
			}
			throw new Exception("Loop doesn't exist");
		}
	}
}
