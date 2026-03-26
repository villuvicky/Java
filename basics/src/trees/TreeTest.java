package trees;

public class TreeTest {


	public static int numberOfNodes(TreeNode<Integer> root) {

		int count=1;

		for(int i=0;i<root.children.size();i++) {

			int childCount=numberOfNodes(root.children.get(i));
			count=count+childCount;
		}
		return count;
	}


	public static int sumOfAllNode(TreeNode<Integer> root) {

		int total=root.data;

		for(int i=0;i<root.children.size();i++) {
			total=total+sumOfAllNode(root.children.get(i));;
		}
		return total;
	}

	public static void printTree(TreeNode<Integer> root) {

		if(root==null) {
			return;
		}

		System.out.print(root.data+" : ");

		for(int i=0;i<root.children.size();i++) {
			System.out.print(root.children.get(i).data+" ");

		}
		System.out.println();
		for(int i=0;i<root.children.size();i++) {
			TreeNode<Integer> child =root.children.get(i);
			printTree(child);
		}
	}

	public static void main(String[] args) {

		TreeNode<Integer> root= new TreeNode<>(0);
		TreeNode<Integer> node1= new TreeNode<>(1);
		TreeNode<Integer> node2= new TreeNode<>(2);
		TreeNode<Integer> node3= new TreeNode<>(3);
		TreeNode<Integer> node4= new TreeNode<>(4);
		TreeNode<Integer> node5= new TreeNode<>(5);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		root.children.add(node4);
		node4.children.add(node5);
		printTree(root);

		System.out.println();
		System.out.println("The size is "+numberOfNodes(root));
		System.out.println("The total is "+sumOfAllNode(root));



	}

}
