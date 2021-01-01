package LinkedListQuestions;

class AddOneToNumberRepresentedByLinkedList_Iterative {
    static class Node {
        int data;
        Node next;
    }
    static Node newNode(int data)
    {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }
    static Node reverse(Node head)
    {
        Node prev=null;
        Node temp = head;
        Node next = null;
        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    static Node addOneUtil(Node head)
    {
        Node ans = head;
        int carry = 1;
        Node temp = null;
        while(head!=null){
            int sum  = head.data+carry;
            carry = sum>=10?1:0;
            sum = sum%10;
            head.data = sum;
            temp = head;
            head = head.next;
        }

        if(carry==1){
            temp.next = newNode(1);
        }
        return ans;
    }
    static Node addOne(Node head)
    {
        head = reverse(head);
        head = addOneUtil(head);
        return reverse(head);
    }
    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
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