package binary_search_tree;

/**
 * this class represent a Binary Search Tree of int
 * @author Eliahu Satat
 */

public class BST {

	private BSNode root;
	private int size;
	
	/**
	 * constructor
	 */
	public BST() {
		this.root = null;
		this.size = 0;
	}
	/**
	 * constructor from array
	 */
	public BST(int arr []) {
		this.root = null;
		this.size = 0;
		for (int i = 0; i < arr.length; i++) {
			this.add(arr[i]);
		}
	}
	
	/**
	 * add element to the tree 
	 * @param data = the data in the new element
	 */
	public void add(int data) {
		BSNode new_node = new BSNode(data);
		if(this.isEmpty()) { // if the tree is empty
			this.root = new_node;
			size++;
		}
		else {
			boolean flag = true;
			BSNode current = this.root;
			while(flag) {
				if(current.getData() > data) { // if data is lower than this node need to go left
					if(current.getLeft() == null) {// if don't have left son insert in this place
						current.setLeft(new_node);
						new_node.setFather(current);
						size++;
						flag = false;
					}
					else {
						current = current.getLeft();
					}
				}
				else {     // if data is bigger or equals to this node need to go right
					if(current.getRight() == null) { // if don't have right son insert in this place
						current.setRight(new_node);
						new_node.setFather(current);
						size++;
						flag = false;
					}
					else {
						current = current.getRight();
					}

				}
			}

		}


	}
	
	/**
	 * remove element from the tree 
	 * @param data = the data of the removed element
	 */
	public boolean remove(int data) {
		if(!this.contain(data)) {
			return false;
		}
		else {
			BSNode current = this.root;
			while(current.getData()!= data) { // find the node to remove
				if (current.getData() > data) {
					current = current.getLeft();
				}
				else {
					current = current.getRight();
				}
			}
			if(current.getLeft()==null&&current.getRight()==null) { // if it is a leaf
				if(current.getFather()==null) { // if he is the root
					this.root = null;
					size --;
				}
				else {
					if(current.getFather().getData() > data) { // if he is the left son
						current.getFather().setLeft(null);
					}
					else {                              // if he is the right son
						current.getFather().setRight(null);	
					}
					current.setFather(null);
					size --;
				}
				return true;
			}
			if(current.getLeft()==null) {// if he has only right son
				if(current.getFather()==null) { // if he is the root
					this.root = current.getRight();
					current.getRight().setFather(null);
					current.setRight(null);
					size --;
				}
				else { // if he is not the root
					if(current.getFather().getData() > data) { // if he is the left son
						current.getFather().setLeft(current.getRight());
						current.getRight().setFather(current.getFather());
					}
					else {                              // if he is the right son
						current.getFather().setRight(current.getRight());
						current.getRight().setFather(current.getFather());
					}
					current.setFather(null);
					current.setRight(null);
					size --;
				}
				return true;
			}
			if(current.getRight()==null) {// if he has only left son
				if(current.getFather()==null) { // if he is the root
					this.root = current.getLeft();
					current.getLeft().setFather(null);
					current.setLeft(null);
					size --;
				}
				else { // if he is not the root
					if(current.getFather().getData() > data) { // if he is the left son
						current.getFather().setLeft(current.getLeft());
						current.getLeft().setFather(current.getFather());
					}
					else {                              // if he is the right son
						current.getFather().setRight(current.getLeft());
						current.getLeft().setFather(current.getFather());
					}
					current.setFather(null);
					current.setLeft(null);
					size --;
				}
				return true;	
			}
			// if he has two sons
			BSNode temp = current.getLeft();
			boolean flag = false;
			while(temp.getRight()!=null) { // find the biggest from the left side
				temp = temp.getRight();
				flag = true;
			}
			current.setData(temp.getData());
			if(flag){  temp.getFather().setRight(null); } // if he is the right son 
			else { temp.getFather().setLeft(null);}// if he is the left son
			temp.setFather(null);
			size--;
			return true;
		}
	}
	
	/**
	 * return the number of elements in the tree
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * return if the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}
	/**
	 * search if the data exist in the tree
	 */
	public boolean contain(int data) {
		return contain_help(this.root, data);
	}
	/**
	 * recursive help function for contain function
	 */
	private boolean contain_help(BSNode head , int data) {
		if (head == null) return false;
		if (head.getData() == data) return true;
		return contain_help(head.getLeft(),data)||contain_help(head.getRight(),data);
	}


	/**
	 * this function print the tree recursively in 3 ways:
	 * (a) Inorder (Left, Root, Right) 
	 * (b) Preorder (Root, Left, Right) 
	 * (c) Postorder (Left, Right, Root) 
	 */
	public void printInOrder() {
		System.out.print("the tree is (InOrder): ");
		printInOrder_help(this.root);
		System.out.println();
	}
	private void printInOrder_help(BSNode head) {
		if( head!= null) {
			printInOrder_help(head.getLeft());
			System.out.print(" "+ head.getData());
			printInOrder_help(head.getRight());
		}

	}
	public void printPreOrder() {
		System.out.print("the tree is (PreOrder): ");
		printPreOrder_help(this.root);
		System.out.println();
	}
	private void printPreOrder_help(BSNode head) {
		if( head!= null) {
			System.out.print(" "+ head.getData());
			printPreOrder_help(head.getLeft());
			printPreOrder_help(head.getRight());
		}

	}
	public void printPostOrder() {
		System.out.print("the tree is (PostOrder): ");
		printPostOrder_help(this.root);
		System.out.println();
	}
	private void printPostOrder_help(BSNode head) {
		if( head!= null) {
			printPostOrder_help(head.getLeft());
			printPostOrder_help(head.getRight());
			System.out.print(" "+ head.getData());

		}

	}


}
