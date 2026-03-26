package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfTree {
	

	public static TreeNode<Integer> takeInput(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter root node data ");
		int rootData=sc.nextInt();
		TreeNode<Integer> root= new TreeNode<>(rootData);
		Queue<TreeNode<Integer>> queue= new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode<Integer> currentNode=queue.poll();
			System.out.println("Enter count for "+currentNode.data);
			int currentNodeCount=sc.nextInt();
			for(int i=0;i<currentNodeCount;i++) {
				System.out.println("Enter data for "+currentNode.data);
				int childData=sc.nextInt();
				TreeNode<Integer> childNode=new TreeNode<>(childData);
				currentNode.children.add(childNode);
				queue.add(childNode);

			}

		}
		sc.close();
		return root;
	}
	
	public static int getHeight(TreeNode<Integer> root) {
		
		if(root==null)
			return 0;
		int maxHeight = 0;
		
		for(TreeNode<Integer> child: root.children) {
			
			int childHeight=getHeight(child);
			maxHeight = Math.max(maxHeight, childHeight);
		}
		return maxHeight+1;
		
	}

	public static void main(String[] args) {
		 TreeNode<Integer> root= takeInput();
		 System.out.println(getHeight(root));

	}

}
