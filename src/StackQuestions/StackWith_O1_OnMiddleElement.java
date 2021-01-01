package StackQuestions;

import java.util.LinkedList;
/* Java Program to implement a stack that supports findMiddle() and deleteMiddle
in O(1) time */

public class StackWith_O1_OnMiddleElement
{
    /* A Doubly Linked List Node */
    class DLLNode
    {
        DLLNode prev;
        int data;
        DLLNode next;
        DLLNode(int d){data=d;}
    }

    /* Representation of the stack data structure that supports findMiddle()
    in O(1) time. The Stack is implemented using Doubly Linked List. It
    maintains pointer to head node, pointer to middle node and count of
    nodes */
    class myStack
    {
        DLLNode head;
        DLLNode mid;
        int count;
    }


    /* Function to create the stack data structure */
    myStack createMyStack()
    {
        myStack ms = new myStack();
        ms.count = 0;
        return ms;
    }


    /* Function to push an element to the stack */
    void push(myStack ms, int new_data)
    {
        DLLNode node = new DLLNode(new_data);
        node.prev = null;
        node.next = ms.head;
        ms.count+=1;
        if(ms.count==1){
            ms.mid = node;
        }
        else{
            ms.head.prev = node;
            if(ms.count%2!=0){
                ms.mid = ms.mid.prev;
            }
        }
        ms.head = node;
    }

    /* Function to pop an element from stack */
    int pop(myStack ms)
    {
        if(ms.count==0){
            throw new RuntimeException( "Stack is empty" );
        }

        DLLNode head = ms.head;
        int data = head.data;
        ms.head = ms.head.next;
        if ( ms.head != null )
            ms.head.prev = null;

        if(ms.count%2==0) ms.mid=ms.mid.next;
        return data;
    }

    // Function for finding middle of the stack
    int findMiddle(myStack ms)
    {
        if(ms.count == 0)
        {
            System.out.println("Stack is empty now");
            return -1;
        }
        return ms.mid.data;
    }

    // Driver program to test functions of myStack
    public static void main(String args[])
    {
        StackWith_O1_OnMiddleElement ob = new StackWith_O1_OnMiddleElement();
        myStack ms = ob.createMyStack();
        ob.push(ms, 11);
        ob.push(ms, 22);
        ob.push(ms, 33);
        ob.push(ms, 44);
        ob.push(ms, 55);
        ob.push(ms, 66);
        ob.push(ms, 77);

        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Middle Element is " + ob.findMiddle(ms));
    }
}

