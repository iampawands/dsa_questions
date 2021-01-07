package BinaryTreeQuestions;

import java.util.HashMap;

import BinaryTreeQuestions.ConstructBTFromPreInorderTraversals_n.Node;

class ConstructBTFromPreInorderTraversals_n2 {
	Node root;
	static int preIndex = 0;
	static HashMap<Character,Integer> inorderMap = new HashMap<Character, Integer>();
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
		
		int inInd = inorderMap.get(root.data);
		
		root.left = buildTree(in, pre, inStrt, inInd-1);
		root.right = buildTree(in, pre, inInd+1, inEnd);		
		return root;
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
		ConstructBTFromPreInorderTraversals_n2 tree = new ConstructBTFromPreInorderTraversals_n2();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		
		for(int i=0;i<len;i++) {
			inorderMap.put(in[i], i);
		}
		
		Node root = tree.buildTree(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}
}
