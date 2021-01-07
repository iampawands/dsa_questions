package BinaryTreeQuestions;

class ConstructBTFromInLevelTraversals  
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
 
 Node constructTree(Node root,int[] levelOrder, int[] inOrder, 
         int inStart, int inEnd)  
 {
	 if(inStart>inEnd) return null;
	 if(inStart==inEnd) {
		 return new Node(inOrder[inStart]);
	 }
	 int index = 0;
	 boolean flag  = false;
	 for(int i=0;i<levelOrder.length-1;i++) {
		 for(int j=inStart;j<inEnd;j++) {
			 if(inOrder[j]==levelOrder[i]) {
				 root = new Node(inOrder[j]);
				 flag = true;
				 index = j;
				 break;
			 }
		 }
		 if(flag) break;
	 }
	 root.left = constructTree(root,levelOrder,inOrder,inStart,index-1);
	 root.right = constructTree(root,levelOrder,inOrder,index+1,inEnd);
	 return root;
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
	 ConstructBTFromInLevelTraversals tree = new ConstructBTFromInLevelTraversals(); 
     int in[] = new int[]{4, 8, 10, 12, 14, 20, 22}; 
     int level[] = new int[]{20, 8, 22, 4, 12, 10, 14}; 
     int n = in.length; 
     Node node = null;
    node = tree.constructTree(node,in, level,0,n-1); 

     /* Let us test the built tree by printing Inorder traversal */
     System.out.print("Inorder traversal of the constructed tree is "); 
     tree.printInorder(node); 
 } 
} 