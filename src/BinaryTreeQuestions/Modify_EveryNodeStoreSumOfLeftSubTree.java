package BinaryTreeQuestions;

import java.util.Stack;

class Modify_EveryNodeStoreSumOfLeftSubTree {

	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;
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
		Modify_EveryNodeStoreSumOfLeftSubTree tree = new Modify_EveryNodeStoreSumOfLeftSubTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
		tree.modifyTree(tree.root);
		tree.iterativeInorder(tree.root);
	}

	private int modifyTree(Node node) {
		if(node==null) return 0;
		int sum = 0;
		int lsum = modifyTree(node.left);
		int rsum = modifyTree(node.right);
		
		node.data = lsum + node.data;
		
		return node.data+rsum;
	}
}

//This code has been contributed by Mayank Jaiswal
