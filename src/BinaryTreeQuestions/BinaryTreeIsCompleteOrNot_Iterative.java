package BinaryTreeQuestions;


import java.util.LinkedList; 
import java.util.Queue; 

public class BinaryTreeIsCompleteOrNot_Iterative
{ 
  /* A binary tree node has data, a pointer to left child 
     and a pointer to right child */
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
  static boolean isCompleteBT(Node root) 
  {
	  if(root==null) return true;
	  
	  Queue<Node> q = new LinkedList<>();
	  q.add(root);
	  Boolean firstLeafFound = false;
	  while(!q.isEmpty()) {
		  Node t = q.poll();
		  
		  if((t.left!=null && firstLeafFound) || (t.right!=null && firstLeafFound) ) {
			  return false;
		  }
		  if(t.left==null && t.right!=null) {
			  return false;
		  }
		  if(t.left==null && t.right==null) {
			  if(!firstLeafFound) {
				  firstLeafFound=true;
			  }
		  }
		  
		  if(t.left!=null) {
			  q.add(t.left);
		  }
		  if(t.right!=null) {
			  q.add(t.right);
		  }
	  }
	  
	  return true;
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
      root.right.left = new Node(6); 
        
      if(isCompleteBT(root) == true) 
          System.out.println("Complete Binary Tree"); 
      else
          System.out.println("NOT Complete Binary Tree"); 
   } 

}