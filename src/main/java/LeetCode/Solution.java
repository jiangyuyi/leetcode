package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> charSet = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int a = 0;//统计前半
        int b = 0;//统计后半

        for (int i=0;i<(s.length()/2);i++){
            if (charSet.contains(s.charAt(i))){
                a++;
            }
        }

        for (int i=(s.length()/2);i<s.length();i++){
            if (charSet.contains(s.charAt(i))){
                b++;
            }
        }

        return a==b;

    }
}
