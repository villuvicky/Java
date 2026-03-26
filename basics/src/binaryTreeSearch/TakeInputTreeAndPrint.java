package binaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputTreeAndPrint {
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
	
	public static void printLevelWise(BinaryTreeNode<Integer> root){
	    if(root == null){
	        return;
	    }
	    Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
	    q.add(root);
	    while(!q.isEmpty()){
	        BinaryTreeNode<Integer> node = q.poll();
	        int left = -1;
	        int right = -1;
	        if(node.left != null){
	            left = node.left.data;
	            q.add(node.left);
	        }
	        if(node.right != null){
	            right = node.right.data;
	            q.add(node.right);
	        }
	        System.out.println(node.data + ":L:" + left + ",R:" + right);
	    }
	}
	public static void printLevelWise2(BinaryTreeNode<Integer> root) {

        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size(); // nodes in current level

            for (int i = 0; i < size; i++) {

                BinaryTreeNode<Integer> current = queue.poll();

                System.out.print(current.data + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // move to next line after one level
            System.out.println();
        }
    }
	public static void main(String[] args) {

		//BinaryTreeNode<Integer> root= treeInput(true, 0, false);
		BinaryTreeNode<Integer> root2= optimizedTakeInput();
		//printTree(root2);
		printLevelWise(root2);
	}

}
