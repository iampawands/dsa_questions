package LinkedListQuestions;

public class SortLinkedListOfZerosOnesTwos { 

	static class Node 
	{ 
		int data; 
		Node next; 
		Node(int data) 
		{ 
			this.data=data; 
		} 
	} 
	// Sort a linked list of 0s, 1s and 2s 
	// by changing pointers. 
	public static Node sortList(Node head) 
	{
		Node zeroD = new Node(0);
		Node oneD = new Node(0);
		Node twoD = new Node(0);
		Node zero = zeroD;
		Node one = oneD;
		Node two = twoD;
		Node cur = head;
		
		while(cur!=null) {
			if(cur.data==0) {
				zero.next = cur;
				zero = zero.next;
			}else if(cur.data==1) {
				one.next = cur;
				one = one.next;
			}else if(cur.data==2) {
				two.next = cur;
				two = two.next;
			}
			cur = cur.next;
		}
		
		zero.next = oneD.next==null?twoD.next:oneD.next;
		one.next = twoD.next;
		two.next = null;
		head = zeroD.next;
		return head;
	} 

	// function to create and return a node 
	public static Node newNode(int data) 
	{ 
		// allocating space 
		Node newNode = new Node(data); 
		newNode.next = null; 
		return newNode; 
	} 
	
	/* Function to print linked list */
	public static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data+" "); 
			node = node.next; 
		} 
	} 

	public static void main(String args[]) { 
		Node head = new Node(1); 
		head.next = new Node(2); 
		head.next.next = new Node(0); 
		head.next.next.next = new Node(1); 
		head.next.next.next.next = new Node(0); 
		head.next.next.next.next.next = new Node(1);
		System.out.println("Linked List Before Sorting"); 
		printList(head); 
		head = sortList(head); 
		System.out.println("\nLinked List After Sorting"); 
		printList(head); 
	} 
} 
