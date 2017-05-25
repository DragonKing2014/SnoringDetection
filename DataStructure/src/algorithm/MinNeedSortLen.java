package algorithm;

import java.util.Arrays;

/**
 * 找出最短需要排序的数组长度
 */
public class MinNeedSortLen {
    public static int findShortest(int[] A, int n) {
        //开始下标
        int start=0;
        //结束下标
        int end=A.length-1;
        int B[]=A.clone();
        Arrays.sort(A);
        for (int i=0;i<=A.length-1;i++){
            start=i;
            if (A[i]!=B[i]){
                break;
            }
        }
        for (int i=A.length-1;i>=start;i--){
            end=i;
            if (A[i]!=B[i]){
                break;
            }
        }


        if (start==end){
            return 0;
        }else{
            return end-start+1;
        }

    }
    public static void main(String args[]){
        int A[]={1,2,3,4,2,1,3,1,4,5,6,7,4,99};
        System.out.println(findShortest(A,A.length));
    }
}
