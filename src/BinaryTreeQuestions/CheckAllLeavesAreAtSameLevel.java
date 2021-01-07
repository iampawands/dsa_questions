package BinaryTreeQuestions;

import java.util.Stack;

class CheckAllLeavesAreAtSameLevel {

	Integer level = null;

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
		while (true) {
			while (node != null) {
				st.push(node);
				node = node.left;
			}
			if (st.isEmpty())
				break;
			Node t = st.pop();
			System.out.print(t.data + " ");
			node = t.right;
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		CheckAllLeavesAreAtSameLevel tree1 = new CheckAllLeavesAreAtSameLevel();
		tree1.root = new Node(10);
		tree1.root.left = new Node(8);
		tree1.root.left.left = new Node(3);
		tree1.root.left.right = new Node(5);
		tree1.root.right = new Node(2);
		tree1.root.right.left = new Node(2);
		System.out.println(tree1.check(tree1.root, 0));
	}

	private boolean check(Node node, int lvl) {
		if(node==null) return true;
		if(node.left==null && node.right==null) {
			if(level==null) {
				level = lvl;
				return true;
			}else if(lvl==level) {
				return true;
			}else {
				return false;
			}
		}
		
		return check(node.left,lvl+1) && check(node.right,lvl+1);
	}
}
