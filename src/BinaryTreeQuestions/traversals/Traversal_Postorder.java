package BinaryTreeQuestions.traversals;

import java.util.Collections;
import java.util.Stack;

import BinaryTreeQuestions.traversals.Traversal_Inorder.Node;

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
		System.out.println("Mehtod 1: ");
		iterativePostorderMethod1(root);
		System.out.println("Method 2: ");
		iterativePostorderMethod2(root);
	}

	// An iterative process to print postorder traversal of Binary tree
	void iterativePostorderMethod1(Node node) {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.push(node);
		while(!st1.isEmpty()) {
			Node t =  st1.pop();
			st2.push(t);
			if(t.left!=null) st1.push(t.left);
			if(t.right!=null) st1.push(t.right);
		}
		Collections.reverse(st2);
		for(Node t: st2) {
			System.out.print(t.data+" ");
		}
		System.out.println();
	}
	
	void iterativePostorderMethod2(Node node) {
		Stack<Node> st = new Stack<>();
		
		do {
			while(node!=null) {
				if(node.right!=null) {
					st.push(node.right);
				}
				st.push(node);
				node = node.left;
			}
			
			node = st.pop();
			
			if(node.right!=null && !st.isEmpty() && node.right==st.peek()) {
				st.pop();
				st.push(node);
				node = node.right;
			}
			else {
				System.out.print(node.data+" ");
				node=null;
			}
		}
		while(!st.isEmpty());
	}

	// driver program to test above functions
	public static void main(String args[]) {
		Traversal_Postorder tree = new Traversal_Postorder();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
		tree.iterativePostorder();
	}
}
