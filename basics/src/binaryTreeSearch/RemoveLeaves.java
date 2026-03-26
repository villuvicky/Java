package binaryTreeSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RemoveLeaves {
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
	 
	 public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
		 
		 if(root==null)
			 return null;
		 
		 if(root.left==null&&root.right==null)
			 return null;
		 
		 root.left=removeLeaves(root.left);
		 root.right=removeLeaves(root.right);
		 return root;
		 
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
	public static void main(String[] args) {
		printLevelWise(removeLeaves(optimizedTakeInput()));
	}

}
