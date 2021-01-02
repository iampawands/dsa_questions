package LinkedListQuestions;
class RearrangeGivenLinkedListInZigZagFashion {
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
		boolean greaterThanExpected = false;
		if(node.data>node.next.data) head = node.next;
		Node prevOfNode = null;
		while(node.next!=null) {
			if(greaterThanExpected && node.data<node.next.data) {
				Node a = node;
				Node b = node.next;
				Node nextOfB = b.next;
				b.next = a;
				a.next = nextOfB;
				if(prevOfNode!=null) prevOfNode.next = b;
				node = b;
			}else if(!greaterThanExpected && node.data>node.next.data) {
				Node a = node;
				Node b = node.next;
				Node nextOfB = b.next;
				b.next = a;
				a.next = nextOfB;
				if(prevOfNode!=null) prevOfNode.next = b;
				node = b;
			}
			greaterThanExpected=!greaterThanExpected;
			prevOfNode=node;
			node = node.next;
		}
	
	}

	public static void main(String[] args) {
		RearrangeGivenLinkedListInZigZagFashion list = new RearrangeGivenLinkedListInZigZagFashion();
		list.head = new Node(4);
		list.head.next = new Node(3);
		list.head.next.next = new Node(7);
		list.head.next.next.next = new Node(8);
		list.head.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next = new Node(2);
		list.head.next.next.next.next.next.next = new Node(1);
		list.printlist(head); // print original list
		list.rearrange(head); // rearrange list as per ques
		System.out.println("");
		list.printlist(head); // print modified list
	}
}