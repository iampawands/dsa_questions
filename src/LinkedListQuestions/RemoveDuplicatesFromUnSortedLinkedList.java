package LinkedListQuestions;


class RemoveDuplicatesFromUnSortedLinkedList {
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
		Node p1 = null, p2 = null, dup = null;
		p1 = head;
		while(p1!=null && p1.next!=null) {
			p2 = p1;
			while(p2.next!=null) {
				if(p2.next.data==p1.data) {
					p2.next = p2.next.next;
				}
				else {
					p2=p2.next;
				}
				
			}
			p1=p1.next;
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
		RemoveDuplicatesFromUnSortedLinkedList llist = new RemoveDuplicatesFromUnSortedLinkedList();
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