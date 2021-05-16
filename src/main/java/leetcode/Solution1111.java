package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1111 {

    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;

        if (len<=1){
            return -1;
        }

        // prefix和appendix存储从头和从尾开始到此位置最短的和为target的长度
        int[] prefix = new int[len];
        int[] appendix = new int[len];
        Arrays.fill(prefix,Integer.MAX_VALUE);
        Arrays.fill(appendix,Integer.MAX_VALUE);


        // key为到此处的和，value为下标
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);
        map.put(0,len);
        int tmp = arr[0];

        for (int i=1;i<len;i++){
            tmp+=arr[i];
            if (map.containsKey(tmp-target)){
                prefix[i] = Math.min(prefix[i-1],i-map.get(tmp-target));
                appendix[map.get(tmp-target)] = Math.min(i-map.get(tmp-target),appendix[map.get(tmp-target)+1]);

            }

            map.put(tmp,i);

        }

        int min = Integer.MAX_VALUE;

        for (int i=1;i<len;i++){
            min = Math.min(min,prefix[i-1]+appendix[i]);
        }
        
        return min;



    }


    
}
