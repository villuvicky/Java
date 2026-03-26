package binaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckTreeBalance {

	public static BinaryTreeNode<Integer> optimizedTakeInput(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=sc.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		Queue <BinaryTreeNode<Integer>> pendingChildren= new LinkedList<>();
		pendingChildren.add(root);
		while(!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front=pendingChildren.poll();
			System.out.println("Enter left data of "+front.data);
			int leftData=sc.nextInt();
			if(leftData!=-1) {
				BinaryTreeNode<Integer> left=new BinaryTreeNode<>(leftData);
				front.left=left;
				pendingChildren.add(left);
			}
			System.out.println("Enter right data of "+front.data);
			int rightData=sc.nextInt();
			if(rightData!=-1) {
				BinaryTreeNode<Integer> right=new BinaryTreeNode<>(rightData);
				front.right=right;
				pendingChildren.add(right);
			}
		}
		return root;
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		return checkHeight(root) != -1;
	}
	private static int checkHeight(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		int left = checkHeight(root.left);
		if (left == -1) 
			return -1;

		int right = checkHeight(root.right);
		if (right == -1) 
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
