package LinkedListQuestions;

import LinkedListQuestions.RotateLinkedList_ByMakingItCircularFirst.Node;

class RotateLinkedList {
	Node head; // head of list

	/* Linked list Node*/
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	// This function rotates a linked list counter-clockwise
	// and updates the head. The function assumes that k is
	// smaller than size of linked list. It doesn't modify
	// the list if k is greater than or equal to size
	void rotate(int k)
	{
		Node curr = head;
		Node ref = curr;
		while(curr!=null && --k>0) {
			curr = curr.next;
		}
		head = curr.next;
		curr.next=null;
		Node tmp = head;
		
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		tmp.next = ref;
	}

	/* Given a reference (pointer to pointer) to the head
		of a list and an int, push a new node on the front
		of the list. */
	void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
		RotateLinkedList llist = new RotateLinkedList();

		// create a list 10->20->30->40->50->60
		for (int i = 60; i >= 10; i -= 10)
			llist.push(i);

		System.out.println("Given list");
		llist.printList();

		llist.rotate(4);

		System.out.println("Rotated Linked List");
		llist.printList();
	}
} /* This code is contributed by Rajat Mishra */
