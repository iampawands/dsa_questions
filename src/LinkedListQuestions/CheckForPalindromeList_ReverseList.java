package LinkedListQuestions;

class CheckForPalindromeList_ReverseList {
	Node head; // head of list
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
	boolean isPalindrome(Node head)
	{
		if(head==null || head.next==null) return true;
		
		slow_ptr = head;
		fast_ptr = head;
		Node prev_to_slow =null;
		while(fast_ptr!=null && fast_ptr.next!=null) {
			fast_ptr = fast_ptr.next.next;
			prev_to_slow = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		Node midNode=null;
		if(fast_ptr!=null) {
			midNode = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		
		prev_to_slow.next = null;
		
		second_half = slow_ptr;
		reverse();
		
		boolean res = compareLists(head, second_half);
		
		reverse();
		
		if(midNode!=null) {
			prev_to_slow.next=midNode;
			prev_to_slow = midNode;
		}
		
		prev_to_slow.next=second_half;
		
		return res;
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
		CheckForPalindromeList_ReverseList llist = new CheckForPalindromeList_ReverseList();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		String string = new String(str);
		for (int i = 0; i < 7; i++) {
			llist.push(str[i]);
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
