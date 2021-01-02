package LinkedListQuestions;


class RearrangeSuchThatEleAtOddEvenPosTogether {
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
		
		Node odd = node;
		Node even = node.next;
		Node evenStart = even;
		
		while(odd.next!=null && even.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
			if(odd.next==null) {
				odd.next = evenStart;
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		RearrangeSuchThatEleAtOddEvenPosTogether list = new RearrangeSuchThatEleAtOddEvenPosTogether();
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