package LinkedListQuestions;

public class IntersectionOfTwoSortedLinkedList_Iterative {
	class node {
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
		IntersectionOfTwoSortedLinkedList_Iterative list = new IntersectionOfTwoSortedLinkedList_Iterative();
		list.head1 = null;
		list.head2 = null;
		list.result = null;
		list.carry = 0;
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
		while(a!=null && b!=null) {
			if(a.val==b.val) {
				dummy.next = new node(a.val);
				dummy = dummy.next;
				a = a.next;
			}
			else if(a.val<b.val) {
				a = a.next;
			}else {
				b = b.next;
			}
		}
	}
}