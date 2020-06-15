package com.tutorials.doubllinkedlist;

public class DoublyLinkedList {

	private int size;
	private Node head;
	private Node tail;

	public void add(int data) {
		Node n = new Node(data);
		if (head == null && tail == null) {
			head = tail = n;
			size++;
		} else {
			Node tmp = tail;
			tail.setNext(n);
			tail = n;
			tail.setPrev(tmp);
			size++;
		}
	}

	public void traverse() {
		if (head == null) {
			System.out.println("No element found in the given linked list");
		} else {
			Node tmp = head;
			
			while (tmp != null) {
				System.out.print(tmp.getData() + " ");
				tmp = tmp.getNext();
			}			
		}
	}

	public void delete(int data) {
		if (head == null) {
			return;
		} else if (head.getData() == data) {
			Node tmp = head;
			head = head.getNext();
			--size;
			tmp.setNext(null);
		} else if (tail.getData() == data) {
			Node tmp = tail;
			tail = tail.getPrev();
			--size;
			tmp.setPrev(null);
			tail.setNext(null);
		} else {
			Node tmp = head;
			while (tmp != null && tmp.getData() != data) {
				tmp = tmp.getNext();
			}
			if (tmp == null) {
				System.out.println("Given data not found");
			} else {
				tmp.getPrev().setNext(tmp.getNext());
				tmp.getNext().setPrev(tmp.getPrev());
				tmp.setPrev(null);
				tmp.setNext(null);
				--size;
			}
		}
	}

	public int getSize() {
		return size;
	}
	
	public void reverse() {
		Node tmp = head;
		while(tmp != null) {
			Node prev = tmp.getNext();
			tmp.setNext(tmp.getPrev());
			tmp.setPrev(prev);
			tmp = tmp.getPrev();
		}
//		Node prev = tmp.getNext();
//		tmp.setNext(tmp.getPrev());
//		tmp.setPrev(prev);
		head = tmp;
	}
}
