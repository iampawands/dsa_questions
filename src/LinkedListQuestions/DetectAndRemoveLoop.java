package LinkedListQuestions;

class DetectAndRemoveLoop {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	int detectAndRemoveLoop(Node node) {
		Node slow,fast;
		slow=fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				removeLoop(slow, node);
			}
		}
		return 0;
	}

	void removeLoop(Node loop, Node curr) {
		Node ptr1,ptr2;
		ptr1=curr;
		
		while(true) {
			ptr2=loop;
			while(ptr2.next!=ptr1 && ptr2.next!=loop) {
				ptr2=ptr2.next;
			}
			
			if(ptr2.next==ptr1) break;
			
			ptr1=ptr1.next;
		}
		ptr2.next=null;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		DetectAndRemoveLoop list = new DetectAndRemoveLoop();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}