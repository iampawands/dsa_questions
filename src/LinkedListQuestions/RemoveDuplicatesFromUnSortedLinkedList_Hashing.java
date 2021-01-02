package LinkedListQuestions;

import java.util.HashMap;
import java.util.Map;

class RemoveDuplicatesFromUnSortedLinkedList_Hashing {
	Node head; // head of list
	/* Linked list Node */

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void removeDuplicates() {
		Map<Integer,Boolean> map = new HashMap<>();
		
		Node curr = head;
		Node prev=null;
		while(curr!=null) {
			
			boolean isPresent = map.getOrDefault(curr.data,false);
			if(isPresent) {
				prev.next=curr.next;
			}else {
				map.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}

	/* Utility functions */
	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);
		/* 3. Make next of new Node as head */
		new_node.next = head;
		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;

		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		RemoveDuplicatesFromUnSortedLinkedList_Hashing llist = new RemoveDuplicatesFromUnSortedLinkedList_Hashing();
		llist.push(10);
		llist.push(11);
		llist.push(12);
		llist.push(11);
		llist.push(11);
		llist.push(12);
		llist.push(10);
		System.out.println("List before removal of duplicates");
		llist.printList();
		llist.removeDuplicates();
		System.out.println("List after removal of elements");
		llist.printList();
	}
}