package BinaryTreeQuestions;


class ConstructBTFromPrePostTraversals  
{ 
 Node root; 

 class Node  
 { 
  int data; 
  Node left, right; 

  Node(int item)  
  { 
      data = item; 
      left = right = null; 
  } 

  public void setLeft(Node left)  
  { 
      this.left = left; 
  } 

  public void setRight(Node right)  
  { 
      this.right = right; 
  } 
 } 
 
 Node constructTree(Node root,int[] pre, int[] post, 
         int preStart, int preEnd)  
 {
	 
	 return null;
 } 

 /* Utility function to print inorder traversal of binary tree */
 void printInorder(Node node)  
 { 
     if (node == null) 
         return; 
     printInorder(node.left); 
     System.out.print(node.data + " "); 
     printInorder(node.right); 
 } 

 // Driver program to test the above functions 
 public static void main(String args[])  
 { 
	 ConstructBTFromPrePostTraversals tree = new ConstructBTFromPrePostTraversals(); 
	 int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	 int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1}; 
     Node node = null;
    node = tree.constructTree(node,pre, post,0,post.length-1); 

     /* Let us test the built tree by printing Inorder traversal */
     System.out.print("Inorder traversal of the constructed tree is "); 
     tree.printInorder(node); 
 } 
} 