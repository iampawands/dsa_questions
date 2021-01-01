package StackQuestions;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void sortStack( Stack<Integer> stack){
        if( stack.isEmpty( ) ) return;
        int temp = stack.pop();
        sortStack(stack);
        myUtil(stack,temp);
    }

    private static void myUtil(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || stack.peek()<temp) {
            stack.push(temp);
            return;
        }
        int t = stack.pop();
        myUtil(stack,temp);
        stack.push(t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(8);
        stack.push(3);
        stack.push(99);
        stack.push(1);
        System.out.println("stack is "+stack );

        sortStack(stack);

        System.out.println("stack is "+stack );
    }
}
