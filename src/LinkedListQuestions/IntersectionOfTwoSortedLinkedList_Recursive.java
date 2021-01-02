package LinkedListQuestions;

import LinkedListQuestions.IntersectionOfTwoSortedLinkedList_Iterative.node;

public class IntersectionOfTwoSortedLinkedList_Recursive {
	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	// Function to print linked list
	void printlist(node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	node head1, head2, result, cur;
	int carry;

	/* A utility function to push a value to linked list */
	void push(int val, int list) {
		node newnode = new node(val);
		if (list == 1) {
			newnode.next = head1;
			head1 = newnode;
		} else if (list == 2) {
			newnode.next = head2;
			head2 = newnode;
		} else {
			newnode.next = result;
			result = newnode;
		}

	}

	
	
	// Driver program to test above functions
	public static void main(String args[]) {
		IntersectionOfTwoSortedLinkedList_Recursive list = new IntersectionOfTwoSortedLinkedList_Recursive();
		list.head1 = null;
		list.head2 = null;
		list.carry = 0;
		list.result = new node(1);
		int arr1[] = { 1,2,3,4,5,6 };
		int arr2[] = { 2,4,6,8};

		// Create first list as 9->9->9
		for (int i = arr1.length - 1; i >= 0; --i)
			list.push(arr1[i], 1);

		// Create second list as 1->8
		for (int i = arr2.length - 1; i >= 0; --i)
			list.push(arr2[i], 2);

		list.findIntersection();

		list.printlist(list.result.next);
	}


	private void findIntersection() {
		
		result = new node(-1);
		node dummy = result;
		node a = this.head1;
		node b = this.head2;
		findIntersectionUtil(a,b);
		result=dummy.next;
	}



	private void findIntersectionUtil(node a, node b) {
		if(a==null || b==null) return;
		
		if(a.val==b.val) {
			result.next = new node(a.val);
			findIntersectionUtil(a.next,b.next);
		}else if(a.val<b.val) {
			findIntersectionUtil(a.next,b);
		}
		else {
			findIntersectionUtil(a,b.next);
		}
	}
}