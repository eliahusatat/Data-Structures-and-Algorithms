package binary_search_tree;

public class test {

	public static void main(String[] args) {
		BST bst = new BST();
		System.out.println(bst.isEmpty());
		bst.add(6);
		bst.add(4);
		bst.add(7);
		bst.add(2);
		bst.add(5);
		bst.printInOrder();
		bst.printPostOrder();
		bst.printPreOrder();
		System.out.println(bst.contain(3));
		System.out.println(bst.contain(5));
		System.out.println(bst.getSize());
		bst.remove(5);
		//bst.printInOrder();
		bst = new BST();
		bst.add(6);
		bst.add(2);
		bst.add(5);
		bst.add(7);
		bst.printInOrder();
		bst.remove(2);
		bst.printInOrder();

	}

}
