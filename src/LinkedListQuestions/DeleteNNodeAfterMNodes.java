package LinkedListQuestions;

//Java program to delete N nodes 
//after M nodes of a linked list 
import java.util.*;

class DeleteNNodeAfterMNodes {

//A linked list node 
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	};

	/* Function to insert a node at the beginning */
	static Node push(Node head_ref, int new_data) {
		if (head_ref == null)
			return new Node(new_data);

		Node temp = new Node(new_data);
		temp.next = head_ref;
		head_ref = temp;
		return head_ref;
	}

	/* Function to print linked list */
	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

//Function to skip M nodes and then 
//delete N nodes of the linked list. 
	static void skipMdeleteN(Node head, int M, int N) {

		Node curr = head, t;
		int count;
		while (curr != null) {
			// Skip M nodes
			for (count = 1; count < M && curr != null; count++)
				curr = curr.next;

			// If we reached end of list, then return
			if (curr == null)
				return;

			// Start from next node and delete N nodes
			t = curr.next;
			for (count = 1; count <= N && t != null; count++) {
				Node temp = t;
				t = t.next;
			}

			// Link the previous list with remaining nodes
			curr.next = t;

			// Set current pointer for next iteration
			curr = t;
		}

	}

//Driver code 
	public static void main(String args[]) {
		/*
		 * Create following linked list 1.2.3.4.5.6.7.8.9.10
		 */
		Node head = null;
		int M = 2, N = 3;
		head = push(head, 10);
		head = push(head, 9);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 6);
		head = push(head, 5);
		head = push(head, 4);
		head = push(head, 3);
		head = push(head, 2);
		head = push(head, 1);

		System.out.println("Given Linked List is:");
		printList(head);

		skipMdeleteN(head, M, N);

		System.out.println("\nLinked list after deletion is :\n");
		printList(head);
	}
}
