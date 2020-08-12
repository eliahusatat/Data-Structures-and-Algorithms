package linked_list;

/**
 * this class represent a single node for linkedlist for int
 * @author Eliahu Satat
 */

public class LLNode implements  Comparable<LLNode>{
	private int data;
	private LLNode next, prev;
	
	public LLNode(int data) {
		this.data = data;
		this.next = this.prev = null;
	}

	/**
	 * getters and setters
	 */
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}

	public LLNode getPrev() {
		return prev;
	}

	public void setPrev(LLNode prev) {
		this.prev = prev;
	}



	@Override
	public int compareTo(LLNode other) {
		// TODO Auto-generated method stub
		return this.data- other.data;
	}

}
