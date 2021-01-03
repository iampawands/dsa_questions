package BinaryTreeQuestions.traversals;

import java.util.Stack;

import BinaryTreeQuestions.traversals.Traversal_Preorder.Node;

class Traversal_Inorder {

	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	void iterativeInorder() {
		iterativeInorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	void iterativeInorder(Node node) {
		Stack<Node> st = new Stack<>();
		while(true) {
			while(node!=null) {
				st.push(node);
				node = node.left;
			}
			if(st.isEmpty()) break;
			Node t = st.pop();
			System.out.print(t.data+" ");
			node = t.right;
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		Traversal_Inorder tree = new Traversal_Inorder();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
		tree.iterativeInorder();
	}
}

//This code has been contributed by Mayank Jaiswal
