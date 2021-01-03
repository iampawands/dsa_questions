package BinaryTreeQuestions;
import java.util.Stack;

//A binary tree node


class Traversal_Preorder {
	
	static class Node {

		int data;
		Node left, right;

		Node(int item)
		{
			data = item;
			left = right = null;
		}
	}
	
	Node root;

	void iterativePreorder()
	{
		iterativePreorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	void iterativePreorder(Node node)
	{
		Stack<Node> st = new Stack<>();
		while(true) {
			while(node!=null) {
				System.out.print(node.data+" ");
				st.push(node);
				node = node.left;
			}
			if(st.isEmpty()) break;
			Node t = st.pop();
			node = t.right;
		}
	}

	// driver program to test above functions
	public static void main(String args[])
	{
		Traversal_Preorder tree = new Traversal_Preorder();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
		tree.iterativePreorder();
	}
}

//This code has been contributed by Mayank Jaiswal
 