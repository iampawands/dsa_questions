package LinkedListQuestions;



//Java program to populate arbit pointers 
//to next higher value using merge sort
class PointArbitPointerToGreatestElementOnRight
{

 static Node head;

 /* Link list node */
 static class Node
 {
     int data;
     Node next, arbit;

     Node(int data) 
     {
         this.data = data;
         next = null;
         arbit = null;
     }
 }

 // Utility function to print result linked list
 void printList(Node node, Node anode)
 {
     System.out.println("Traversal using Next Pointer");
     while (node != null)
     {
         System.out.print(node.data + " ");
         node = node.next;
     }

     System.out.println("\nTraversal using Arbit Pointer");
     while (anode != null)
     {
         System.out.print(anode.data + " ");
         anode = anode.arbit;
     }
 }

 private Node reverse(Node head) {
	Node prev=null;
	Node next=null;
	
	while(head!=null) {
		next = head.next;
		head.next = prev;
		prev= head;
		head = next;
	}
	return prev;
 }
 // This function populates arbit pointer in every node to the 
 // next higher value. And returns pointer to the node with 
 // minimum value
 	
 private Node populateArbit(Node start)
 {
	 start = reverse(start);
	 Node temp = start;
	 Node maxNode = temp;
	 temp = temp.next;
	 while(temp!=null) {
		 temp.arbit = maxNode;
		 if(temp.data>maxNode.data) {
			 maxNode = temp;
		 }
		 temp = temp.next;
	 }
	 return reverse(start);
 }

 // Driver code
 public static void main(String[] args)
 {
	 PointArbitPointerToGreatestElementOnRight list = new PointArbitPointerToGreatestElementOnRight();

     /* Let us create the list shown above */
     list.head = new Node(5);
     list.head.next = new Node(10);
     list.head.next.next = new Node(2);
     list.head.next.next.next = new Node(3);

     /* Sort the above created Linked List */
     Node ahead = list.populateArbit(head);

     System.out.println("Result Linked List is:");
     list.printList(head, ahead);
 }
}