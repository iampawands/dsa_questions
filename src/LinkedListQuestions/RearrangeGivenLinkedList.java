package LinkedListQuestions;

//Linked List Class
class RearrangeGivenLinkedList {
	static Node head; // head of list
	/* Node Class */

	static class Node {
		int data;
		Node next;

//Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void printlist(Node node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
	}

	Node reverselist(Node node) {
		Node prev = null, curr = node, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}

	void rearrange(Node node) {
		if(node==null || node.next==null) return;
		Node temp = node;
		while(temp.next!=null) {
			Node t1 = temp;
			
			Node prevToLast =null;
			Node lastNode = t1.next;
			while(lastNode.next!=null) {
				prevToLast =  lastNode;
				lastNode = lastNode.next;
			}
			
			if(prevToLast!=null) {
				prevToLast.next=null;
				lastNode.next = temp.next;
				temp.next=lastNode;
			}
			
			temp = temp.next.next;
		}
	}

	public static void main(String[] args) {
		RearrangeGivenLinkedList list = new RearrangeGivenLinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.printlist(head); // print original list
		list.rearrange(head); // rearrange list as per ques
		System.out.println("");
		list.printlist(head); // print modified list
	}
}