package binaryTreeSearch;

public class BinaryTreeUse {
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		System.out.print(root.data+" : ");
		
		if(root.left!=null) {
			System.out.print("L "+root.left.data+",");
		}
		if(root.right!=null) {
			System.out.print("R : "+root.right.data);
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> rootLeft= new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> rootRight= new BinaryTreeNode<Integer>(30);
		BinaryTreeNode<Integer> twoRight= new BinaryTreeNode<Integer>(40);
		BinaryTreeNode<Integer> threeLeft= new BinaryTreeNode<Integer>(50);
		
		root.left=rootLeft;
		root.right=rootRight;
		
		rootLeft.right=twoRight;
		rootRight.left=threeLeft;
		
		
		printTree(root);

	}

}
