package BinaryTreeQuestions;


import java.util.LinkedList; 
import java.util.Queue; 

public class BinaryTreeIsCompleteOrNot_Recursive  
{ 
  /* A binary tree node has data, a pointer to left child 
     and a pointer to right child */
 static boolean firstLeafFound = false;
 static int firstLeafLevel = -1;
  static class Node 
  { 
      int data; 
      Node left; 
      Node right; 
        
      // Constructor 
      Node(int d) 
      { 
          data = d; 
          left = null; 
          right = null; 
      } 
  } 
  
  static boolean isCompleteBTUtil(Node node,int index,int no_nodes) {
	  if(node==null) return true;
	  
	  if(index>=no_nodes) {
		  return false;
	  }
	  
	  return isCompleteBTUtil(node.left,2*index+1,no_nodes) && isCompleteBTUtil(node.right,2*index+2,no_nodes);
  }
  static int countNodes(Node root) {
	  if(root==null) return 0;
	  
	  int lcnt = countNodes(root.left);
	  int rcnt = countNodes(root.right);
	  
	  return 1+lcnt+rcnt;
  }
  /* Given a binary tree, return true if the tree is complete 
     else false */
  static boolean isCompleteBT(Node root) 
  {
	  int cnt = countNodes(root);
	  return isCompleteBTUtil(root,0,cnt);
  } 
    
  /* Driver program to test above functions*/
  public static void main(String[] args)  
  { 
        
      /* Let us construct the following Binary Tree which 
        is not a complete Binary Tree 
              1 
            /   \ 
           2     3 
          / \     \ 
         4   5     6 
      */
     
      Node root = new Node(1); 
      root.left = new Node(2); 
      root.right = new Node(3); 
      root.left.left = new Node(4); 
      root.left.right = new Node(5); 
      root.right.right = new Node(6); 
      firstLeafFound=false;
      firstLeafLevel = -1;
      if(isCompleteBT(root) == true) 
          System.out.println("Complete Binary Tree"); 
      else
          System.out.println("NOT Complete Binary Tree"); 
   } 

}