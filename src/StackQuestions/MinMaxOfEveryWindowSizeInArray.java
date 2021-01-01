package StackQuestions;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinMaxOfEveryWindowSizeInArray {

    Map<Integer,Integer> map = new HashMap<>(  );

    public static void printArray(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 50, 10, 70, 30};
        int len = arr.length;

        //nextSmaller[i]-prevSmaller[i]-1 will give the window size for which arr[i] is minimum.
        int prevSmaller[] = prevSmaller(arr); //index of previous smaller
        int nextSmaller[] = nextSmaller(arr); //index of next smaller

        printArray(arr);
        printArray(prevSmaller);
        printArray(nextSmaller);

        printMaxOfMin(arr,nextSmaller,prevSmaller, len);
    }

    private static void printMaxOfMin(int[] arr, int[] nextSmaller, int[] prevSmaller, int len) {

        for(int i=0;i<len;i++){
            int res = nextSmaller[i]-prevSmaller[i]-1;
            System.out.println("For window size: "+res+" min element is: "+arr[i]);
        }
    }

    private static int[] prevSmaller(int[] arr) {
        int len = arr.length;
        int output[] = new int[len];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i=len-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek().getValue()>arr[i]){
                    Pair pair = stack.pop();
                    output[(int) pair.getKey()]=i;
                }
            }
            stack.push(new Pair<>(i,arr[i]));
        }
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            output[(int) pair.getKey()]= -1;
        }
        return output;
    }

    private static int[] nextSmaller(int[] arr) {
        int len = arr.length;
        int output[] = new int[len];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i=0;i<len;i++){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek().getValue()>arr[i]){
                    Pair pair = stack.pop();
                    output[(int) pair.getKey()]=i;
                }
            }
            stack.push(new Pair<>(i,arr[i]));
        }
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            output[(int) pair.getKey()]= len;
        }
        return output;

    }

}
