package BinaryTreeQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckAllLeavesAreSameLevel_Iterative {

	static class Node {

		int data;
		Node left, right;
		int lvl;

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
		CheckAllLeavesAreSameLevel_Iterative tree1 = new CheckAllLeavesAreSameLevel_Iterative();
		tree1.root = new Node(10);
		tree1.root.left = new Node(8);
		tree1.root.left.left = new Node(3);
		tree1.root.left.right = new Node(5);
		tree1.root.right = new Node(2);
//		tree1.root.right.left = new Node(2);
		System.out.println(tree1.check(tree1.root, 0));
	}

	private boolean check(Node node, int lvl) {
		Queue<Node> q = new LinkedList<>();
		node.lvl=1;
		q.add(node);
		int resultantLevel = -1;
		boolean ans = true;
		while(!q.isEmpty()) {
			Node t = q.poll();
			int l = t.lvl;
			if(t.left==null && t.right==null) {
				if(resultantLevel ==-1) {
					resultantLevel = l;
				}else if(resultantLevel!=l){
					ans = false;
					break;
				}
			}
			if(t.left!=null) {
				t.left.lvl = l+1;
				q.add(t.left);
			}
			if(t.right!=null) {
				t.right.lvl=l+1;
				q.add(t.right);
			}
		}
		return ans;
	}
}
