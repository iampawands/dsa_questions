package BinaryTreeQuestions;

import java.util.Stack;

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
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.isEmpty())
				break;
			Node temp = stack.pop();
			System.out.print(temp.data+" ");
			node = temp.right;
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		Traversal_Inorder tree = new Traversal_Inorder();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.iterativeInorder();
	}
}

//This code has been contributed by Mayank Jaiswal
