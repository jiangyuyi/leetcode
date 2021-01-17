package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dic = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> resultSet = new TreeSet<>();

        for (String word:words){
            StringBuffer key = new StringBuffer();
            for (int i=0;i<word.length();i++){
                key.append(dic[word.charAt(i)-'a']);
            }
            resultSet.add(key.toString());
        }

        return resultSet.size();

    }
    
}
