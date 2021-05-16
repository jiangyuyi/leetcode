package leetcode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution873 {
    public List<Integer> fibList() {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){


            @Override
            public int compare(Integer arg0, Integer arg1) {
                // TODO Auto-generated method stub
                return 0;
            }
            
        });

        List<Integer> fib = new ArrayList<>();
        int tmp = 2;
        fib.add(1);
        fib.add(1);
        while (tmp <1000000000 && tmp>0){
            fib.add(tmp);
            System.out.print(tmp+",");
            tmp = fib.get(fib.size()-2)+fib.get(fib.size()-1);
        }

        

        return fib;
        


    }

    public static void main(String[] args) {

        Solution873 solution873 = new Solution873();
        solution873.fibList();
    }
}