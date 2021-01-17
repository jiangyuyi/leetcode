package leetcode;

public class Solution927 {
    public int[] threeEqualParts(int[] A) {

        int count = 0;
        for (int a:A){
            count+=a;
        }

        if (count%3!=0){
            return new int[]{-1,-1};
        }

        if (count == 0 ){
            return new int[]{0,A.length-1};
        }

        int a=0,b=A.length-1;
        int countS = 0,countE = 0;

        // 1 切分成三个1的数量相同的部分
        while (a<b && (countS<count/3 || countE<count/3)){
            if (countS<count/3){
                countS+=A[a];
                a++;
            }
            if (countE<count/3){
                countE+=A[b];
                b--;
            }
        }

        b++;

        // 2 第一部分把所有0补在后面，第三部分第一位先用1
        while (A[a]==0){
            a++;
        }
        a--;

        if (A.length-b>a+1|| A.length-b>b-a+1){
            System.out.println("len error");
            return new int[]{-1,-1};
        }

        int tmp1 = 0;
        while (A[tmp1]==0){
            tmp1++;
        }

        int tmp2=a+1;
        while (A[tmp2]==0){
            tmp2++;
        }

        // 3 比较三个部分排列是否一致
        for (int i=0;i<A.length-b;i++){
            if (A[tmp1+i]!=A[b+i]|| A[b+i]!=A[tmp2+i]){
                System.out.println("val error");
                return new int[]{-1,-1};
            }
        }

        // 4 将第一部分调整成第三部分所需要的最短长度（忽略前导0）
        a=A.length-b-1+tmp1;
        b=a+1+tmp2-tmp1;

        return new int[]{a,b};

    }

    public static void main(String[] args) {
        Solution927 solution927 = new Solution927();
        System.out.println(solution927.threeEqualParts(new int[]{1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,
                                                                 1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,
                                                                 0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,
                                                                 0,0}));
        
    }
    
}
