package leetcode;

import java.util.Stack;

class Solution20 {
    public boolean isValid(String s) {

        Stack<Character> tmp = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (!tmp.isEmpty()){
                if (isPair(tmp.peek(), s.charAt(i))){
                    tmp.pop();
                }else {
                    tmp.push(s.charAt(i));
                }
            }
        }

        if (tmp.isEmpty()){
            return true;
        }

        return false;
        
    }

    private boolean isPair(char a,char b){
        return (a=='(' && b==')') || (a=='[' && b==']')||(a=='{' && b=='}');
    }

    public static void main(String[] args){
        Solution20 Solution20 = new Solution20();
        System.out.println(Solution20.isValid("{}"));
        
    }
}