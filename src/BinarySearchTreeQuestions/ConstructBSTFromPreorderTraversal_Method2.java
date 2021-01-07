package BinarySearchTreeQuestions;
class ConstructBSTFromPreorderTraversal_Method2 {

	class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}
	int index = 0;
	Node constructTree(int pre[], int size) {
		return constructTreeUtil(pre,Integer.MIN_VALUE,Integer.MAX_VALUE,size);
	}

	private Node constructTreeUtil(int[] pre,int min, int max, int size) {
		
		
		return null;
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

		ConstructBSTFromPreorderTraversal_Method2 tree = new ConstructBSTFromPreorderTraversal_Method2();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}
