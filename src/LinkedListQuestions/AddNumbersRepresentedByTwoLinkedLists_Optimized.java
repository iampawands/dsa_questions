package LinkedListQuestions;

// Java program to add two linked lists

public class AddNumbersRepresentedByTwoLinkedLists_Optimized 
{
    class node 
    {
        int val;
        node next;
 
        public node(int val) 
        {
            this.val = val;
        }
    }
     
    // Function to print linked list
    void printlist(node head) 
    {
        while (head != null) 
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
 
    node head1, head2, result,cur;
    int carry;
 
    /* A utility function to push a value to linked list */
    void push(int val, int list) 
    {
        node newnode = new node(val);
        if (list == 1) 
        {
            newnode.next = head1;
            head1 = newnode;
        } 
        else if (list == 2) 
        {
            newnode.next = head2;
            head2 = newnode;
        } 
        else
        {
            newnode.next = result;
            result = newnode;
        }
 
    }
 
    void addsamesize(node n, node m) 
    {
    	if(n==null || m==null) return;
    	
    	addsamesize(n.next, m.next);
    	int sum = n.val+m.val+carry;
    	carry = sum/10;
    	sum%=10;
    	push(sum,3);
    }
    void propogatecarry(node head1) 
    {
    	if(head1==cur) return;
    	propogatecarry(head1.next);
    	
    	int sum = head1.val+carry;
    	carry = sum/10;
    	sum%=10;
    	push(sum,3);
    }
 
    int getsize(node head) 
    {
    	 int count=0;
    	 while(head!=null) {
    		 count++;
    		 head=head.next;
    	 }
    	 return count;
    }
 
    void addlists() 
    {
        if(head1==null) {
        	result = head2;
        	return;
        }
        if(head2==null) {
        	result = head1;
        	return;
        }
        
        int size1 = getsize(head1);
        int size2 = getsize(head2);
        if(size1==size2) {
        	addsamesize(head1, head2);
        }else{
        	if(size2>size1) {
        		node tmp = head1;
        		head1=head2;
        		head2=tmp;
        	}
        	int diff = Math.abs(size1-size2);
        	cur = head1;
        	if(diff-->0) {
        		cur = cur.next;
        	}
        	
        	addsamesize(cur, head2);
        	
        	propogatecarry(head1);
        }
         if(carry>0) {
        	 push(carry,3);
         }
    }
 
    // Driver program to test above functions
    public static void main(String args[])
    {
    	AddNumbersRepresentedByTwoLinkedLists_Optimized list = new AddNumbersRepresentedByTwoLinkedLists_Optimized();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };
 
        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);
 
        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);
 
        list.addlists();
 
        list.printlist(list.result);
    }
}