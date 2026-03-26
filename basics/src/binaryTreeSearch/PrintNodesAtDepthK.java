package binaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNodesAtDepthK {
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
	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){

	    if(root == null){
	        return;
	    }

	    if(k == 0){
	        System.out.print(root.data + " ");
	        return;
	    }

	    printAtDepthK(root.left, k - 1);
	    printAtDepthK(root.right, k - 1);
	}
	
	

	    public static void replaceWithDepth(BinaryTreeNode<Integer> root) {
	        helper(root, 0);
	    }

	    private static void helper(BinaryTreeNode<Integer> node, int depth) {
	        if (node == null) return;

	        // Replace data with depth
	        node.data = depth;

	        // Traverse left and right
	        helper(node.left, depth + 1);
	        helper(node.right, depth + 1);
	    }
	
	public static void main(String[] args) {
		printAtDepthK(optimizedTakeInput(), 2);
	}

}
