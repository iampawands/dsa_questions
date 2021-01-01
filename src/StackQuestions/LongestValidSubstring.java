package StackQuestions;

import java.util.Stack;

public class LongestValidSubstring {

    public static void main(String[] args) {
        String str = "()(()))))";
        findLongestValidSubstring(str);
    }

    private static void findLongestValidSubstring(String str) {
        int len = str.length();
        Stack<Integer> stack = new Stack<>();
        int maxEle = Integer.MIN_VALUE;
        stack.push(-1);
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='(') {
                stack.push(i);
            }else{
                stack.pop();

                if(!stack.isEmpty()){
                    maxEle = Math.max(maxEle,i-stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }
        System.out.println(maxEle);
    }
}
