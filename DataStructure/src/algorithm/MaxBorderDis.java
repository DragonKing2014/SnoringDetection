package algorithm;

import java.util.Arrays;

/**
 * 求一个数组排序后相邻元素最大差值
 */
public class MaxBorderDis {
    public static int findMaxDivision(int[] A, int n) {
        //数组从小到大排序
        Arrays.sort(A);
        int maxDis=0;
        for(int i=1;i<=A.length-1;i++){
            if (A[i]-A[i-1]>=maxDis){
                maxDis=A[i]-A[i-1];
            }
        }
        return maxDis;
    }

    public static void main(String[] args){
        int[] array={1,2,4,5,2,1,7,3,100,50};
        System.out.println(findMaxDivision(array,array.length));
    }
}
