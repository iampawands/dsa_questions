package LinkedListQuestions;

class FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber {
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

	/*
	 * A function to chech if there are three elements in a, b and c whose sum is
	 * equal to givenNumber. The function assumes that the list b is sorted in
	 * ascending order and c is sorted in descending order.
	 */
	boolean isSumSorted(FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber la,
			FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber lb,
			FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber lc, int givenNumber) {
		
		Node headA = la.head;
		
		
		while(headA!=null) {
			Node headB = lb.head;
			Node headC = lc.head;
			while(headB!=null && headC!=null) {
				int dataA = headA.data;
				int dataB = headB.data;
				int dataC = headC.data;
				int sum = dataA+dataB+dataC;
				if(sum==givenNumber) {
					System.out.println("A,B and C are: "+dataA+" "+dataB+" "+dataC);
					return true;
				}else if(sum<givenNumber) {
					headB = headB.next;
				}else {
					headC=headC.next;
				}
			}
			
			headA=headA.next;
		}
		
		return true;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and an int, push
	 * a new node on the front of the list.
	 */
	void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);
		/* 3. Make next of new Node as head */
		new_node.next = head;
		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber llist1 = new FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber();
		FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber llist2 = new FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber();
		FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber llist3 = new FindTripletsOneFromEachThreeLinkedListWithSumEqualGivenNumber();

		llist1.push(20);
		llist1.push(5);
		llist1.push(15);
		llist1.push(100);

		llist2.push(10);
		llist2.push(9);
		llist2.push(4);
		llist2.push(2);

		llist3.push(1);
		llist3.push(2);
		llist3.push(4);
		llist3.push(8);
		int givenNumber = 25;
		llist1.isSumSorted(llist1, llist2, llist3, givenNumber);
	}
}