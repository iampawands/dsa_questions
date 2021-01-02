package LinkedListQuestions;

import LinkedListQuestions.PointArbitPointerToGreatestElementOnRight.Node;

class RearrangeGivenLinkedList_Efficient {
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
	
	void printlist(Node node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
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
		
		Node slow,fast,prevToSlow;
		slow =fast=node;
		prevToSlow=null;
		while(fast!=null && fast.next!=null) {
			prevToSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node middleNode = null;
		if(fast!=null) {
			middleNode = slow;
			slow = slow.next;
		}
		
		prevToSlow.next=null;
		Node firstHalf = node;
		Node secondHalf = slow;
		secondHalf = reverse(secondHalf);

		Node lastNode=null;
		while(firstHalf!=null) {
			Node nextA = firstHalf.next;
			Node nextB = secondHalf.next;
			firstHalf.next = secondHalf;
			secondHalf.next=nextA;
			secondHalf = nextB;
			if(firstHalf.next.next==null) {
				lastNode = firstHalf.next;
			}
			firstHalf = firstHalf.next.next;
			
		}
		if(middleNode!=null && lastNode!=null) {
			middleNode.next=null;
			lastNode.next=middleNode;
		}
	}

	public static void main(String[] args) {
		RearrangeGivenLinkedList_Efficient list = new RearrangeGivenLinkedList_Efficient();
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