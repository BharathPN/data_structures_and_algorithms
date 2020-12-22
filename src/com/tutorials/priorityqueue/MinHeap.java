package com.tutorials.priorityqueue;

//Java implementation of Min Heap 
public class MinHeap { 

	private int[] minHeap; 
	private int size; 
	private int maxSize; 

	private static final int FRONT = 1; 

	public MinHeap(int maxSize) 
	{ 
		this.maxSize = maxSize; 
		this.size = 0; 
		minHeap = new int[this.maxSize + 1]; 
		minHeap[0] = Integer.MIN_VALUE; 
	} 

	private int parent(int i) 
	{ 
		return i / 2; 
	} 

	private int leftChild(int i) 
	{ 
		return (2 * i); 
	} 

	private int rightChild(int i) 
	{ 
		return (2 * i) + 1; 
	} 

	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int i, int j) 
	{ 
		minHeap[i] = minHeap[i] ^ minHeap[j];
		minHeap[j] = minHeap[i] ^ minHeap[j];
		minHeap[i] = minHeap[i] ^ minHeap[j];
	} 

	// Function to heapify the node at pos 
	private void minHeapify(int pos) 
	{ 

		// If the node is a non-leaf node and greater 
		// than any of its child 
		if (!isLeaf(pos)) { 
			if (minHeap[pos] > minHeap[leftChild(pos)] 
				|| minHeap[pos] > minHeap[rightChild(pos)]) { 

				// Swap with the left child and heapify 
				// the left child 
				if (minHeap[leftChild(pos)] < minHeap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 

				// Swap with the right child and heapify 
				// the right child 
				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 

	// Function to insert a node into the heap 
	public void insert(int element) 
	{ 
		if (size >= maxSize) { 
			return; 
		} 
		minHeap[++size] = element; 
		int current = size; 

		while (minHeap[parent(current)] > minHeap[current]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	// Function to print the contents of the heap 
	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + minHeap[i] 
							+ " LEFT CHILD : " + minHeap[2 * i] 
							+ " RIGHT CHILD :" + minHeap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	// Function to build the min heap using 
	// the minHeapify 
	public void minHeap() 
	{ 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
	} 

	// Function to remove and return the minimum 
	// element from the heap 
	public int remove() 
	{ 
		int popped = minHeap[FRONT]; 
		minHeap[FRONT] = minHeap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	} 

	// Driver code 
	public static void main(String[] arg) 
	{ 
		System.out.println("The Min Heap is "); 
		MinHeap minHeap = new MinHeap(15); 
		minHeap.insert(5); 
		minHeap.insert(3); 
		minHeap.insert(17); 
		minHeap.insert(10); 
		minHeap.insert(84); 
		minHeap.insert(19); 
		minHeap.insert(6); 
		minHeap.insert(22); 
		minHeap.insert(9); 
		minHeap.minHeap(); 

		minHeap.print(); 
		System.out.println("The Min val is " + minHeap.remove()); 
		
		
	} 
} 
