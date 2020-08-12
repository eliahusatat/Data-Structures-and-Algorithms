package linked_list;

import java.util.Iterator;

public class linked_list implements Iterable<LLNode>{
	LLNode head, tail;
	int size;

	public linked_list() {
		head = tail = null;
		size = 0;
	}
	
	public linked_list(int arr []) {
		head = tail = null;
		size = 0;
		for (int i = 0; i < arr.length; i++) {
			this.insert_tail(arr[i]);
		}
	}

	public void insert_head(int data) {
		System.out.println("in insert_head with:"+ data);
		if(isempty()) {
			head = tail = new LLNode(data);
			size++;
		}
		else {
			LLNode new_node = new LLNode(data);
			new_node.setNext(head);
			head.setPrev(new_node);
			head = new_node;
			size++;
		}
	}
	public int getSize() {
		return this.size;
	}

	public void insert_tail(int data) {
		if(isempty()) {
			head = tail = new LLNode(data);
			size++;
		}
		else {
			LLNode new_node = new LLNode(data);
			new_node.setPrev(tail);
			tail.setNext(new_node);
			tail = new_node;
			size++;
		}
	}

	public void insert_index(int index , int data) {
		if (this.getSize() < index) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		else {
			if(this.getSize() == index) {
				this.insert_tail(data);
			}
			else {
				if(index == 0) {
					this.insert_head(data);
				}
				else {
					LLNode new_node = new LLNode(data);
					LLNode current = this.head;
					for (int i = 0; i < index ; i++) {
						current = current.getNext();
					}															
					LLNode prev = current.getPrev();
					new_node.setNext(current);
					new_node.setPrev(prev);
					prev.setNext(new_node);
					current.setPrev(new_node);
					size++;
				}


			}

		}
	}

	public void delete_head() throws Exception {
		if(this.isempty()) {
			throw new Exception("the list is empty!");
		}
		else {
			if(size == 1) {
				head = tail = null;
				size --;
			}
			else {
				LLNode temp = head ;
				head = temp.getNext();
				head.setPrev(null);
				temp.setNext(null);
				size --;
			}
		}
	}
	
	
	public void delete_tail() throws Exception {
		if(this.isempty()) {
			throw new Exception("the list is empty!");
		}
		else {
			if(size == 1) {
				head = tail = null;
				size --;
			}
			else {
				LLNode temp = tail ;
				tail = temp.getPrev();
				tail.setNext(null);
				temp.setPrev(null);
				size --;
			}
		}
	}



	public boolean delete(int data) throws Exception {
		if(!this.contain(data)) {
			throw new Exception("this data doesent exist!");
		}
		else {

			LLNode current = head;
			while(current.getData()!=data) { // find the node
				current = current.getNext();
			}
			if(current.getNext()==null&&current.getPrev()==null) {//if there is one node
				head = tail = null;
				size--;
				return true;
			}
			if(current.getNext()==null) {//if he is the tail
				tail = current.getPrev();
				current.getPrev().setNext(null);
				size--;
				return true;
			}
			if(current.getPrev()==null) {// if he is the head
				head = current.getNext();
				current.getNext().setPrev(null);
				size--;
				return true;
			}
			// the basic case - in the middle
			LLNode next = current.getNext();
			LLNode prev = current.getPrev();
			next.setPrev(prev);
			prev.setNext(next);
			current.setNext(null);
			current.setPrev(null);
			size--;
			return true;


		}

	}


	public boolean isempty() {
		return this.size == 0;
	}

	public boolean contain(int data) {
		return contain_help(this.head,data);

	}

	private boolean contain_help(LLNode start , int data){
		if(start == null) return false;
		if(start.getData() == data) return true;
		return contain_help(start.getNext(),data);
	}
	
	public int sum() {
		return sum_help(this.head);
		
	}
	private int sum_help(LLNode start) {
		if(start == null) return 0;
		else {
			return start.getData()+sum_help(start.getNext());
		}
	}

	public String toString() {
		String ans ="";
		LLNode temp = head;
		while(temp!=null) {
			ans += " "+temp.getData();
			temp = temp.getNext();
		}
		return ans;
	}
	public String toString1() {
		String ans ="";
		Iterator<LLNode> it = this.iterator();
		while(it.hasNext()) {
			ans += " "+it.next().getData();
		}
		return ans;
	}


	public Iterator<LLNode> iterator() {
		return new Iterator<LLNode>() {

			LLNode current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public LLNode next() {
				if(hasNext()){
					LLNode data = current;
					current = current.getNext();
					return data;
				}
				return null;
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException("Remove not implemented.");
			}

		};
	}

}
