package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindSecondLargest {
	
	static TreeNode<Integer> largest = null;
	static TreeNode<Integer> secondLargest = null;
	
	public static TreeNode<Integer> takeInput(){

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter root value ");
		int rootData= sc.nextInt();
		TreeNode<Integer> root= new TreeNode<>(rootData);
		Queue<TreeNode<Integer>> queue= new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode<Integer> currentNode=queue.poll();
			System.out.println("Enter childNode count for current Node "+ currentNode.data );
			int childCount=sc.nextInt();
			for(int i=0;i<childCount;i++) {
				System.out.println("Enter childNode data ");
				int childData=sc.nextInt();
				TreeNode<Integer> childNode= new TreeNode<>(childData);
				currentNode.children.add(childNode);
				queue.add(childNode);
			}
		}
		return root;
	}

	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {

	    largest = null;
	    secondLargest = null;

	    dfs(root);

	    return secondLargest;
	}

	private static void dfs(TreeNode<Integer> root) {

	    if (root == null) return;

	    if (largest == null || root.data > largest.data) {
	        secondLargest = largest;
	        largest = root;
	    } 
	    else if (root.data < largest.data) {
	        if (secondLargest == null || root.data > secondLargest.data) {
	            secondLargest = root;
	        }
	    }

	    for (TreeNode<Integer> child : root.children) {
	        dfs(child);
	    }
	}
	public static void main(String[] args) {
		TreeNode<Integer> root=takeInput();
		System.out.println(findSecondLargest(root).data);
	}

}
