package BinaryTreeQuestions;

import java.util.Stack;

public class Traversal_Postorder {

	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	void iterativePostorder() {
		iterativePostorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	void iterativePostorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while (true) {
			if (stack.isEmpty())
				break;
			node = stack.peek();
			while (node.left != null) {
				stack.push(node.left);
				node = node.left;
			}
			if (node.right == null)
				System.out.println(node.data + " ");
			stack.push(node);
			stack.push(node.right);
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		Traversal_Postorder tree = new Traversal_Postorder();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.iterativePostorder();
	}
}
