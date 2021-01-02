package LinkedListQuestions;

/* Java program to check if linked list is palindrome recursively */
import java.util.*;

class CheckForPalindromeList_Stack {
	public static void main(String args[])
	{
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);
		one.ptr = two;
		two.ptr = three;
		three.ptr = four;
		four.ptr = five;
		five.ptr = six;
		six.ptr = seven;
		boolean condition = isPalindrome(one);
		System.out.println("isPalidrome :" + condition);
	}
	static boolean isPalindrome(Node head)
	{
		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head;
		while(temp!=null) {
			stack.push(temp.data);
			temp = temp.ptr;
		}
		temp = head;
		while(temp!=null && !stack.isEmpty()) {
			int data = stack.pop();
			if(temp.data!=data) return false;
			
			temp = temp.ptr;
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}

class Node {
	int data;
	Node ptr;
	Node(int d)
	{
		ptr = null;
		data = d;
	}
}
