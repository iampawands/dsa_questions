package LinkedListQuestions;

class AddOneToNumberRepresentedByLinkedList_Recursive {

    /* Linked list node */
    static class Node
    {
        int data;
        Node next;
    }

    /* Function to create a new node with given data */
    static Node newNode(int data)
    {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    // Recursively add 1 from end to beginning and returns
    // carry after all nodes are processed.
    static int addWithCarry(Node head)
    {
    	if(head==null) return 1;
    	int sum = head.data + addWithCarry(head.next);
    	head.data = sum%10;
    	return sum/10;
    }

    // This function mainly uses addWithCarry().
    static Node addOne(Node head)
    {
    	int carry = addWithCarry(head);
    	if(carry>=1) {
    		Node temp = newNode(1);
    		temp.next=head;
    		head=temp;
    	}
    	return head;
    }

    // A utility function to print a linked list
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    /* Driver code */
    public static void main(String[] args)
    {
        Node head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);

        System.out.print("List is ");
        printList(head);

        head = addOne(head);
        System.out.println();
        System.out.print("Resultant list is ");
        printList(head);
    }
}

// This code is contributed by shubham96301
