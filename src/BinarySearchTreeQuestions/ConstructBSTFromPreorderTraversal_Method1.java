package BinarySearchTreeQuestions;

class ConstructBSTFromPreorderTraversal_Method1 {

	class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	Node constructTree(int pre[], int size) {
		return constructTreeUtil(pre,0,size-1);
	}

	private Node constructTreeUtil(int[] pre,int i, int j) {
		if(i>j) return null;
		Node root = new Node(pre[i]);
		
		int leftInd = i+1;
		while(leftInd<j && pre[i]>pre[leftInd]) {
			leftInd++;
		}
		root.left = constructTreeUtil(pre,i+1,leftInd-1);
		root.right = constructTreeUtil(pre,leftInd,j);
		return root;
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {

		ConstructBSTFromPreorderTraversal_Method1 tree = new ConstructBSTFromPreorderTraversal_Method1();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}
