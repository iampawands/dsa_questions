package LinkedListQuestions;

class CheckForPalindromeList_Recursion {
	Node head,tempNode; // head of list
	Node slow_ptr, fast_ptr, second_half;

	/* Linked list Node*/
	class Node {
		char data;
		Node next;

		Node(char d)
		{
	
			data = d;
			next = null;
		}
	}

	/* Function to check if given linked list is
	palindrome or not */
	boolean isPalindrome(Node h)
	{
		if(h==null) return true;
		
		boolean ans = isPalindrome(h.next);
		
		if(!ans) return false;
		
		ans = tempNode.data==h.data;
		tempNode=tempNode.next;
		return ans;
	}

	
	/* Function to reverse the linked list Note that this
	function may change the head */
	void reverse()
	{
		Node prev = null;
		Node current = second_half;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half = prev;
	}

	/* Function to check if two input lists have same data*/
	boolean compareLists(Node head1, Node head2)
	{
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			else
				return false;
		}

		/* Both are empty reurn 1*/
		if (temp1 == null && temp2 == null)
			return true;

		/* Will reach here when one is NULL
		and other is not */
		return false;
	}

	/* Push a node to linked list. Note that this function
	changes the head */
	public void push(char new_data)
	{
		/* Allocate the Node &
		Put in the data */
		Node new_node = new Node(new_data);

		/* link the old list off the new one */
		new_node.next = head;

		/* Move the head to point to new Node */
		head = new_node;
	}

	// A utility function to print a given linked list
	void printList(Node ptr)
	{
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	/* Driver program to test the above functions */
	public static void main(String[] args)
	{

		/* Start with the empty list */
		CheckForPalindromeList_Recursion llist = new CheckForPalindromeList_Recursion();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		String string = new String(str);
		for (int i = 0; i < 7; i++) {
			llist.push(str[i]);
			llist.tempNode=llist.head;
			llist.printList(llist.head);
			if (llist.isPalindrome(llist.head) != false) {
				System.out.println("Is Palindrome");
				System.out.println("");
			}
			else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
		}
	}
}
