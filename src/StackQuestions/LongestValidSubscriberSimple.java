package StackQuestions;

public class LongestValidSubscriberSimple {
    public static void main(String[] args) {
        String str = "()(()))))";
        int maxEle = Integer.MIN_VALUE;
        int len = str.length();
        for(int i=0;i<len;i++){
            for(int j=i;j<=len;j++){
                String tempStr = str.substring(i,j);
                int currLen = tempStr.length();
                boolean isValid = ValidParenthesisString.isValidString(tempStr);
                if(isValid && currLen>maxEle) maxEle=currLen;
            }
        }

        System.out.println(maxEle );
    }
}
