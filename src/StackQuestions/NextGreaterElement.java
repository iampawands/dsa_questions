package StackQuestions;

import java.util.Stack;

public class NextGreaterElement
{
    static void printNGE(int arr[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(!stack.isEmpty( ) && stack.peek()<arr[i]){
                int t = stack.pop();
                System.out.println("Next Greater of "+t+" is"+arr[i] );
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.println("Next Greater of "+stack.pop()+" is -1");
        }
    }

    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }
}