package BinaryTreeQuestions.traversals;

import java.util.Stack;

import BinaryTreeQuestions.traversals.Traversal_Preorder.Node;

class Traversal_Boundary {

	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	void boundaryTraversal() {
		Node node = root;
		printLeftView(node);
		printBottomView(node);
		printRightView(node);
	}

	private void printRightView(Node node) {
		if(node!=null) {
			if(node.right!=null) {
				printLeftView(node.right);
				System.out.print(node.data+" ");
			}else if(node.left!=null){
				printLeftView(node.left);
				System.out.print(node.data+" ");
			}else {
				return;
			}
		}
	}

	private void printBottomView(Node node) {
		if(node==null) return;
		printBottomView(node.left);
		if(node.left==null && node.right==null) 
			System.out.print(node.data+" ");
		printBottomView(node.right);
		
	}

	private void printLeftView(Node node) {
		if(node!=null) {
			if(node.left!=null) {
				System.out.print(node.data+" ");
				printLeftView(node.left);
			}else if(node.right!=null){
				System.out.print(node.data+" ");
				printLeftView(node.right);
			}else {
				return;
			}
		}
	}

	// An iterative process to print preorder traversal of Binary tree
	void boundaryTraversal(Node node) {
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
		Traversal_Boundary tree = new Traversal_Boundary();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
		tree.boundaryTraversal();
	}
}

//This code has been contributed by Mayank Jaiswal
