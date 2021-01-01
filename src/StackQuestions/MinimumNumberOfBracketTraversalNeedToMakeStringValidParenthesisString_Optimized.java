package StackQuestions;

import java.util.Stack;

public class MinimumNumberOfBracketTraversalNeedToMakeStringValidParenthesisString_Optimized {
    public static void main(String[] args) {
        String expr = "}{{}}{{{";
        System.out.println("Reversals Needed: "+countMinReversals(expr));
    }

    private static int countMinReversals(String expr) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<expr.length();i++){
            if(!stack.empty() && stack.peek()=='{' && expr.charAt(i)=='}'){
                stack.pop();
            }else{
                stack.push(expr.charAt(i));
            }
        }
        int result_len = stack.size();
        int opening = 0;
        while(!stack.isEmpty() && stack.peek()=='{'){
            stack.pop();
            opening++;
        }
        ans = result_len/2 + opening%2;
        return ans;
    }
}
