package StackQuestions;

import java.util.Stack;

public class ValidParenthesisString {
    public static boolean isValidString(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='['){
                stack.push(str.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                int charAtTop = stack.pop();
                int currentchar = str.charAt(i);
                if(currentchar=='}' && charAtTop!='{') return false;
                if(currentchar==']' && charAtTop!='[') return false;
                if(currentchar==')' && charAtTop!='(') return false;
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}
