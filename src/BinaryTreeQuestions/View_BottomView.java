package BinaryTreeQuestions;

import java.util.*;
import java.util.Map.Entry;



// Main driver class
public class View_BottomView {
	
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

	//Tree class
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
		public void bottomView() {
			Queue<Node> q  = new LinkedList<Node>();
			Map<Integer,Integer> m = new TreeMap();
			Node node = root;
			node.hd=0;
			q.add(node);
			while(!q.isEmpty()) {
				Node t = q.poll();
				int hd = t.hd;
				m.put(hd, t.data);
				if(t.left!=null) {
					t.left.hd = hd-1;
					q.add(t.left);
				}
				if(t.right!=null) {
					t.right.hd=hd+1;
					q.add(t.right);
				}
			}
			
			Set s = m.entrySet();
			Iterator it = s.iterator();
			while(it.hasNext()) {
				Entry entry = (Entry) it.next();
				System.out.print(entry.getValue()+" ");
			}
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
		System.out.println("Bottom view of the given binary tree:");
		tree.bottomView();
	}
}
