package binaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodeWoithLargestData {
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

	public static int largest(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftMax=largest(root.left);
		int rightMax=largest(root.right);
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x){
	    if(root == null){
	        return 0;
	    }
	    int count = 0;
	    if(root.data > x){
	        count = 1;
	    }
	    int leftCount = countNodesGreaterThanX(root.left, x);
	    int rightCount = countNodesGreaterThanX(root.right, x);
	    return count + leftCount + rightCount;
	}
	public static void main(String[] args) {
		
		System.out.println(largest(optimizedTakeInput()));

	}

}
