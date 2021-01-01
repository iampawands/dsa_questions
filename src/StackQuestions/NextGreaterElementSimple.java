package StackQuestions;
import java.util.Stack;

public class NextGreaterElementSimple
{
    static void printNGE(int arr[], int n){
       int maxEle = arr[arr.length-1];
       int len = arr.length;
       System.out.println(maxEle+" --> "+-1);
       for(int i=len-2;i>=0;i--){
           if(arr[i]>maxEle){
               maxEle=arr[i];
               System.out.println(arr[i]+" --> "+-1);
           }
           else{
               System.out.println(arr[i]+" --> "+maxEle);
           }
       }
    }

    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }
}