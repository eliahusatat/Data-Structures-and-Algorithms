package binary_search_tree;


/**
 * this class represent a single node for Binary Search Tree for int
 * @author Eliahu Satat
 */

public class BSNode implements  Comparable<BSNode>{
	private int data;
	private BSNode right, left , father;
	
	public BSNode(int data) {
		this.data = data;
		this.right = this.left = this.father = null;
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

	public BSNode getRight() {
		return right;
	}

	public void setRight(BSNode right) {
		this.right = right;
	}

	public BSNode getLeft() {
		return left;
	}

	public void setLeft(BSNode left) {
		this.left = left;
	}

	public BSNode getFather() {
		return father;
	}

	public void setFather(BSNode father) {
		this.father = father;
	}




	@Override
	public int compareTo(BSNode other) {
		// TODO Auto-generated method stub
		return this.data- other.data;
	}


}
