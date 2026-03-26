package binaryTreeSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeOrder {
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

	public static ArrayList<Integer> preorder(BinaryTreeNode<Integer> root) {

		ArrayList<Integer> result = new ArrayList<>();
		preorderHelper(root, result);
		return result;
	}
	public static void preorderHelper(BinaryTreeNode<Integer> root, ArrayList<Integer> result){
		if(root == null){
			return;
		}
		result.add(root.data);          
		preorderHelper(root.left, result);   
		preorderHelper(root.right, result);  
	}
	public static ArrayList<Integer> preorder2(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		result.add(root.data);
		ArrayList<Integer> left = preorder(root.left);
		ArrayList<Integer> right = preorder(root.right);

		result.addAll(left);
		result.addAll(right);
		return result;
	}
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null){
			return;
		}
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null){
			return;
		}
		preOrder(root.left);
		System.out.print(root.data + " ");
		preOrder(root.right);
	}
	public static void main(String[] args) {

		System.out.println(preorder(optimizedTakeInput()));

	}

}
