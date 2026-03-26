package binaryTreeSearch;

import java.util.Scanner;

public class NumberOfNodes {

	public static BinaryTreeNode<Integer> treeInput(boolean isRoot, int parentData, boolean isLeft) {
		if(isRoot) {
			System.out.println("Enter root data");
		}
		else
		{
			if(isLeft) {
				System.out.println("Enter left child of " +parentData);
			}
			else {
				System.out.println("Enter right child of " +parentData);
			}
		}
		Scanner sc= new Scanner(System.in);
		int rootData= sc.nextInt();

		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root= new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> rootLeft= treeInput(false, rootData, true);
		BinaryTreeNode<Integer> rootRight= treeInput(false, rootData, false);
		root.left=rootLeft;
		root.right=rootRight;
		return root;
	}
	
	public static int numberOfNodes(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return 0;
		}
		
		int leftNodeCount= numberOfNodes(root.left);
		int rightNodeCount= numberOfNodes(root.right);
		
		return 1+rightNodeCount+leftNodeCount;
	}
	
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

		BinaryTreeNode<Integer> root= treeInput(true, 0, false);
		System.out.println(numberOfNodes(root));
	}


}
