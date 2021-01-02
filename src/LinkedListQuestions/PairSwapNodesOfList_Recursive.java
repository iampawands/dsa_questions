package LinkedListQuestions;

class PairSwapNodesOfList_Recursive {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to pairwise swap elements of a linked list */
	Node pairWiseSwap(Node node) {
		if(node==null || node.next==null) return node;
		Node temp = node.next.next;
		Node a = node;
		Node b = node.next;
		Node res = b;
		
		b.next = a;
		a.next = pairWiseSwap(temp);
		
		return res;
	}

	/* Function to print nodes in a given linked list */
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

// Driver program to test above functions
	public static void main(String[] args) {
///* The constructed linked list is:

		PairSwapNodesOfList_Recursive list = new PairSwapNodesOfList_Recursive();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		System.out.println("Linked list before calling pairwiseSwap() ");
		list.printList(head);
		Node st = list.pairWiseSwap(head);
		System.out.println("");
		System.out.println("Linked list after calling pairwiseSwap() ");
		list.printList(st);
		System.out.println("");

	}

}