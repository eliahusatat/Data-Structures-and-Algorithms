package stack;


/**
 * this class represent a stack  (fifo)
 * @author Eliahu Satat
 */

public class stack {
	
	private SNode top ;

	public stack() {
		top = null;
	}

	
	/**
	 * return if the queue is empty
	 */
	public boolean isEmpty() {
		return  top == null;
	}

	
	/**
	 * return the data of the  element in the top of the stack 
	 * @throws if the stack is empty
	 */
	public int peek() throws Exception {
		if(this.isEmpty()) throw new Exception("the stack is empty!");
		else {
			return top.getData();
		}
	}

	/**
	 * insert element to the stack
	 */
	public void push (int data) {
		SNode new_node = new SNode(data);
		if(this.isEmpty()) {
			top = new_node;
		}
		else {
			new_node.setNext(top);
			top = new_node;
		}
	}
	
	
	/**
	 * return the element in the top of the stack
	 *  @throws if the stack is empty
	 */
	public int pop() throws Exception {
		if(this.isEmpty()) throw new Exception("the stack is empty!");
		else {
			int data = top.getData();
			SNode temp = top;
			top = top.getNext();
			temp.setNext(null);
			return data;
		}
	}

}
