package BinaryTreeQuestions;

import java.util.LinkedList; 
import java.util.Queue; 

public class CheckBinaryTreeIsFull  
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
  
  /* Given a binary tree, return true if the tree is complete 
     else false */
  static boolean isFullBT(Node root) 
  {
	  if(root==null) return true;
	  
	  if(root.left==null && root.right==null) return true;
	  
	  if(root.left!=null && root.right!=null)
		  return isFullBT(root.left) && isFullBT(root.right);
	  return false;
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
//      root.right.left = new Node(6);
      firstLeafFound=false;
      firstLeafLevel = -1;
      if(isFullBT(root) == true) 
          System.out.println("Full Binary Tree"); 
      else
          System.out.println("NOT Full Binary Tree"); 
   } 

}