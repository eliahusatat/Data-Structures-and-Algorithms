package queue;

/**
 * this class represent a queue  (lifo)
 * @author Eliahu Satat
 */

public class queue {
	private QNode head; // remove from head 
	private QNode tail; // add to the tail
	
	/**
	 * constructor
	 */
	public queue() {
		this.head = this.tail = null;
	}
	
	
	/**
	 * return if the queue is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * return the data of the first element in the queue
	 * @throws Exception if the queue is empty
	 */
	public int peek() throws Exception {
		if(this.isEmpty()) throw new Exception("the stack is empty!");
		else {
			return head.getData();
		}
	}
	
	/**
	 * insert element to the queue
	 */
	public void push(int data) {
		QNode new_node = new QNode(data);
		if(this.isEmpty()) {
			head = tail = new_node;
		}
		else {
			tail.setNext(new_node);
			tail = new_node; 
		}
	}
	
	/**
	 * return the element in the start of the queue
	 * @throws Exception if the queue is empty
	 */
	public int pop() throws Exception {
		if(this.isEmpty()) throw new Exception("the queue is empty!");
		else {
		int data = head.getData();
		QNode temp = head;
		head = head.getNext();
		temp.setNext(null);
		return data;
		}
	}
	

}
