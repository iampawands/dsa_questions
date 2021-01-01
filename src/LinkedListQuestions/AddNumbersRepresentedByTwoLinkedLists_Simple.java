package LinkedListQuestions;


//Java program to add two numbers
//represented by linked list

class AddNumbersRepresentedByTwoLinkedLists_Simple {

 static Node head1, head2;

 static class Node {

     int data;
     Node next;

     Node(int d)
     {
         data = d;
         next = null;
     }
 }

 /* Adds contents of two linked
lists and return the head node
of resultant list */
 Node addTwoLists(Node first, Node second)
 {
	 Node res = null;
	 Node prev = null;
	 Node newNode = null;
	 int carry = 0;
	 while(first!=null || second!=null) {
		 int firstData = first!=null?first.data:0;
		 int secondData = second!=null?second.data:0;
		 int sum = firstData+secondData+carry;
		 newNode = new Node(sum);
		 if(res == null) {
			 res = newNode;
		 }else {
			 prev.next=newNode;
		 }
		 prev = newNode;
		 if(first!=null) first = first.next;
		 if(second!=null) second = second.next;
	 }
	 
	 return res;
 }
 /* Utility function to print a linked list */

 void printList(Node head)
 {
     while (head != null) {
         System.out.print(head.data + " ");
         head = head.next;
     }
     System.out.println("");
 }

 // Driver Code
 public static void main(String[] args)
 {
	 AddNumbersRepresentedByTwoLinkedLists_Simple list = new AddNumbersRepresentedByTwoLinkedLists_Simple();
	 //Numbers are given in reverse order.
     // creating first list
     list.head1 = new Node(7);
     list.head1.next = new Node(5);
     list.head1.next.next = new Node(9);
     list.head1.next.next.next = new Node(4);
     list.head1.next.next.next.next = new Node(6);
     System.out.print("First List is ");
     list.printList(head1);

     // creating seconnd list
     list.head2 = new Node(8);
     list.head2.next = new Node(4);
     System.out.print("Second List is ");
     list.printList(head2);

     // add the two lists and see the result
     Node rs = list.addTwoLists(head1, head2);
     System.out.print("Resultant List is ");
     list.printList(rs);
 }
}
