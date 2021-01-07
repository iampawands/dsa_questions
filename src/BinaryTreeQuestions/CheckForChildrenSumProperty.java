package BinaryTreeQuestions;

import java.util.Stack;

class CheckForChildrenSumProperty {

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
		CheckForChildrenSumProperty tree = new CheckForChildrenSumProperty();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
	    tree.root.right = new Node(30);
	    tree.root.left.left = new Node(40);
	    tree.root.left.left.left = new Node(70);
	    tree.root.left.right = new Node(50);
	    tree.root.right.left = new Node(60);
	    tree.root.left.left.right = new Node(80);
	    
	    CheckForChildrenSumProperty tree1 = new CheckForChildrenSumProperty();
	    tree1.root = new Node(10);
	    tree1.root.left = new Node(8);
	    tree1.root.left.left=new Node(3);
	    tree1.root.left.right=new Node(5);
	    tree1.root.right=new Node(2);
	    tree1.root.right.left=new Node(2);
		System.out.println("Tree 1: "+tree.check(tree.root));
		System.out.println("Tree 2: "+tree1.check(tree1.root));
	}

	private boolean check(Node node) {
		if(node==null) return true;
		if(node.left==null && node.right==null) return true;
		
		check(node.left);
		check(node.right);
		int lsum = node.left!=null?node.left.data:0;
		int rsum = node.right!=null?node.right.data:0;
		
		return node.data==lsum+rsum;
		
	}
}

//This code has been contributed by Mayank Jaiswal
