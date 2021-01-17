package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public List<String> letterCombinations(String digits) {

        Map<String,List<String>> dic = new HashMap<>();
        dic.put("2",Arrays.asList("a","b","c"));
        dic.put("3",Arrays.asList("d","e","f"));
        dic.put("4",Arrays.asList("g","h","i"));
        dic.put("5",Arrays.asList("j","k","l"));
        dic.put("6",Arrays.asList("m","n","o"));
        dic.put("7",Arrays.asList("p","q","r","s"));
        dic.put("8",Arrays.asList("t","u","v"));
        dic.put("9",Arrays.asList("w","x","y","z"));

        return letterCombinations(digits, dic);

    }

    public List<String> letterCombinations(String digits,Map<String,List<String>> dic){
        List<String> result = new ArrayList<>();

        if (digits.length()==0){
            return new ArrayList<>();
        }

        if (digits.length()==1){
            result.addAll(dic.get(digits));
            return result;
        }

        List<String> prevList = letterCombinations(digits.substring(0, digits.length()-1),dic);
        int startLen = prevList.size();
        String lastKey = digits.substring(digits.length()-1);

        List<String> appendList = dic.get(lastKey);

        for (int i=0;i<appendList.size();i++){
            int startTmp = prevList.size() - startLen;
            if (i<appendList.size()-1){
                prevList.addAll(prevList.subList(prevList.size()-startLen, prevList.size()));
                startTmp = prevList.size() - startLen*2;
            }

            
            for (int j=0;j<startLen;j++){
                prevList.set(startTmp+j,prevList.get(startTmp+j)+appendList.get(j));
            }

        }

        return prevList;


    }

    public static void main(String[] args){
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }


}
