package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution5638 {

    class Apple {

        public Apple(int getDay,int expireDay){
            this.getDay = getDay;
            this.expireDay = expireDay;
        }

        public int getDay;
        public int expireDay;

    }

    public int eatenApples(int[] apples, int[] days) {

        // 存储苹果队列，有序，存储的值是第几天坏
        Queue<Apple> appleQueue = new PriorityQueue<>(new Comparator<Apple>(){
			@Override
			public int compare(Apple arg0, Apple arg1) {
                if (arg0.expireDay-arg1.expireDay!=0){
                    return arg0.expireDay-arg1.expireDay;	
                }
                return arg0.getDay-arg1.getDay;	
			}
            
        });

        int n = apples.length;
        int eat = 0;
        int date = 0;

        while (appleQueue.size()>0 || date<n) {
            if (date<n){
                for (int j=0;j<apples[date];j++){
                    appleQueue.offer(new Apple(date,date+days[date]));
                }
            }

            if (appleQueue.size()>0){
Apple  getApple = appleQueue.poll();
            while (getApple.expireDay<=date && appleQueue.size()>0){
                getApple = appleQueue.poll();//清理过期的
            }

            if (getApple.expireDay>date){
                eat++;
            }
            

            date++;


        }
    }

        return eat;

    }

    public static void main(String[] args){
        Solution5638 solution5638 = new Solution5638();
        System.out.println(solution5638.eatenApples(new int[]{3,0,0,0,0,2},new int[]{3,0,0,0,0,2}));
        
    }
    
}
