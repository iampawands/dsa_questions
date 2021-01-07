package BinaryTreeQuestions;

class CheckIfTwoNodesAreCousins {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// Recursive function to check if two Nodes are
	// siblings
	boolean isSibling(Node node, Node a, Node b) {
		if(node==null) return false;
		
		return (
				(node.left==a && node.right==b) ||
				(node.left==b && node.right==a) ||
				isSibling(node.left, a, b) || isSibling(node.right, a, b)
				);
	}

	// Recursive function to find level of Node 'ptr' in
	// a binary tree
	int level(Node node, Node ptr, int lev) {
		if(node==null) return -1;
		
		if(node ==  ptr) {
			return lev;
		}
		
		int l = level(node.left,ptr,lev+1);
		int r = level(node.right,ptr,lev+1);
		if(l==-1) return r;
		return l;
	}

	// Returns 1 if a and b are cousins, otherwise 0
	boolean isCousin(Node node, Node a, Node b) {
		if(node==null) return true;
		
		return level(node,a,0)==level(node,b,0) && !isSibling(node, a, b);
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		CheckIfTwoNodesAreCousins tree = new CheckIfTwoNodesAreCousins();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(15);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		Node Node1, Node2;
		Node1 = tree.root.left.left;
		Node2 = tree.root.left.right;
		if (tree.isCousin(tree.root, Node1, Node2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

