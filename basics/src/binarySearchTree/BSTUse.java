package binarySearchTree;

public class BSTUse {
	
	public static void main(String[] args) {
		
		BST bst= new BST();
		bst.insert(5);
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(10);
		bst.insert(9);
		bst.printTree();
		System.out.println(bst.isPresent(51));
		System.out.println(bst.size());
	}

}
