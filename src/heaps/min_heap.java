package heaps;

import java.util.Arrays;

/**
 * this class represent a min heap 
 * @author Eliahu Satat
 */
public class min_heap {
	private int capacity ; // the actual size of the array
	private int size;  // the number of element in the heap
	private int items [];
	
	/**
	 * constructor
	 * @param capacity - Initial value for the size of the array
	 */
	public min_heap(int capacity) {
		this.capacity = capacity;  
		this.size = 0;   
		items = new int [capacity];
	}
	
	/**
	 * constructor
	 * with Initial value for the size of the array 16
	 */
	public min_heap() {
		this(16);
	}
	
	/**
	 * constructor
	 * from array
	 */
	public min_heap(int arr []) { // need to add this
		this(arr.length*2);
		for (int i = 0; i < arr.length; i++) {
			this.add(arr[i]);
		}
	}
	
	
	
	/**
	 * calculate the index in the array of the left child
	 * @param parentIndex the index of the node we want his left child index
	 * @return this index
	 */
	private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1 ;}
	
	
	
	/**
	 * calculate the index in the array of the right child
	 * @param parentIndex the index of the node we want his right child index
	 * @return this index
	 */
	private int getRightChildIndex(int parentIndex) {return 2*parentIndex + 2 ;}
	
	
	/**
	 * calculate the index in the array of the parent
	 * @param childIndex the index of the node we want his parent index
	 * @return this index
	 */
	private int getParentIndex(int childIndex) {return (childIndex -1)/2 ;}
	
	
	/** 
	 * @param parentIndex the index of the node we want to chack if he has left child
	 * @return if he has left child
	 */
	private boolean hasLeftChild(int parentIndex) {return (this.getLeftChildIndex(parentIndex) < this.size) ;}
	
	
	/**
	 * @param parentIndex the index of the node we want to chack if he has right child
	 * @return if he has right child
	 */
	private boolean hasRightChild(int parentIndex) {return (this.getRightChildIndex(parentIndex) < this.size) ;}
	
	/**
	 * @param childIndex the index of the node we want to chack if he has parent
	 * @return
	 */
	private boolean hasParent(int childIndex) {return (this.getParentIndex(childIndex) < this.size) ;}
	
	
	/**
	 * @param parentIndex the index of the node we want his left child 
	 * @return his left child
	 */
	private int leftChild(int parentIndex) { return items[getLeftChildIndex(parentIndex)];}
	
	/**
	 * 
	 * @param parentIndex the index of the node we want his right child 
	 * @return his right child
	 */
	private int rightChild(int parentIndex) {return items[getRightChildIndex(parentIndex)];}
	
	
	/**
	 * 
	 * @param childIndex the index of the node we want his parent
	 * @return his parent
	 */
	private int parent(int childIndex) {return items[getParentIndex(childIndex)];}
	
	
	/**
	 * swap between two element in the array
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swap(int firstIndex , int secondIndex) {
			int temp = items[firstIndex];
			items[firstIndex] = items[secondIndex];
			items[secondIndex] = temp;
	}
	
	/**
	 * ensure that if the size gets to the full capacity double the capacity
	 */
	private void ensureExtraCapacity() {
		if(size == capacity) {
			this.items = Arrays.copyOf(items,capacity *2);
			this.capacity = this.capacity*2;
		}
	}
	
	/**
	 * @return the first element (without remove it)
	 */
	public int peek() {
		return items[0];
	}
	
	/**
	 * add new element to the heap
	 * @param data - the data of the new element
	 */
	public void add(int data) {
		ensureExtraCapacity();
		items[size]= data;
		size ++;
		heapifyUp();
	}
	
	/**
	 * pull the min (first) element from the heap
	 * @return the min element 
	 */
	public int pull() {
		int data = items[0];
		System.out.println(items[0]+" "+items[size - 1]);
		swap(0,size - 1);
		System.out.println(items[0]+" "+items[size - 1]);
		printArr();
		size -- ;
		printArr();
		heapifyDown();
		return data;
	}
	
	/**
	 * find the current place of the data in the last place (after adding new data)
	 */
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index)&&(items[index] < parent(index))) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	/**
	 *find the current place of the data in the first place (after removeing)  
	 */
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerSonIndex = getLeftChildIndex(index);
			if((hasRightChild(index))&&(items[getRightChildIndex(index)] < items[getLeftChildIndex(index)])) {
				smallerSonIndex = getRightChildIndex(index);
			}
			if(items[index] < items[smallerSonIndex]) {
				break;
			}
			else {
				swap(index , smallerSonIndex);
				index = smallerSonIndex;
				
			}
		}
		
	}
	
	/**
	 * print the array of the heap 
	 */
	public void printArr() {
		for (int i = 0; i < size; i++) {
			System.out.print(","+items[i]);
		}
		System.out.println();
	}

}
