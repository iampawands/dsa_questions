package BinaryTreeQuestions.view;

import java.util.*;
import java.util.Map.Entry;

// Main driver class
public class View_LeftView {
	static int maxLevel = Integer.MIN_VALUE;
   	static List<Integer> leftView = new ArrayList();
	// Tree node class
	static class Node {
		int data; // data of the node
		int hd; // horizontal distance of the node
		Node left, right; // left and right references

		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	// Tree class
	static class Tree {
		Node root; // root node of tree
		// Default constructor

		public Tree() {
		}

		// Parameterized tree constructor
		public Tree(Node node) {
			root = node;
		}

		// Method that prints the bottom view.
		public void leftView() {
			Node node = root;
			leftViewUtil(node,0);
			for(int i:leftView) {
				System.out.print(i+" ");
			}
		}
		
		private void leftViewUtil(Node node, int level) {
			if(node==null) return;
			
			if(level>maxLevel) {
				leftView.add(node.data);
				maxLevel = level;
			}
			leftViewUtil(node.left, level+1);
			leftViewUtil(node.right, level+1);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		Tree tree = new Tree(root);
		System.out.println("Left view of the given binary tree:");
		tree.leftView();
	}
}
