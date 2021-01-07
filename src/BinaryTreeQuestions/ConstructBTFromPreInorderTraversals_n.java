package BinaryTreeQuestions;

/* A binary tree node has data, pointer to left child
and a pointer to right child */


class ConstructBTFromPreInorderTraversals_n {
	Node root;
	static int preIndex = 0;
	static class Node {
		char data;
		Node left, right;

		Node(char item)
		{
			data = item;
			left = right = null;
		}
	}
	/* Recursive function to construct binary of size len from
	Inorder traversal in[] and Preorder traversal pre[].
	Initial values of inStrt and inEnd should be 0 and len -1. 
	The function doesn't do any error checking for cases where 
	inorder and preorder do not form a tree */
	Node buildTree(char in[], char pre[], int inStrt, int inEnd)
	{
		if(inStrt>inEnd) return null;
		
		Node root = new Node(pre[preIndex++]);
		
		if(inStrt == inEnd) return root;
		
		int inInd = search(in, inStrt, inEnd, root.data);
		
		root.left = buildTree(in, pre, inStrt, inInd-1);
		root.right = buildTree(in, pre, inInd+1, inEnd);		
		return root;
	}

	/* UTILITY FUNCTIONS */

	/* Function to find index of value in arr[start...end]
	The function assumes that value is present in in[] */
	int search(char arr[], int strt, int end, char value)
	{
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	/* This funtcion is here just to test buildTree() */
	void printInorder(Node node)
	{
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	// driver program to test above functions
	public static void main(String args[])
	{
		ConstructBTFromPreInorderTraversals_n tree = new ConstructBTFromPreInorderTraversals_n();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = tree.buildTree(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}
}
