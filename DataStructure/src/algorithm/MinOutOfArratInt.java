package algorithm;

/**
 * @author wang.jl
 * 题目：给定一个整数数组A和数组的大小n，请返回数组中未出现的最小正整数。保证数组大小小于等于500
 */
public class MinOutOfArratInt {
    public static int findArrayMex(int[] A, int n) {
        int[] memory=new int[0xFFF];
        for (int i=0;i<A.length;i++){
            if (A[i]>=0) {
                memory[A[i]]++;
            }
        }
        for (int j=1;j<512;j++){
            if (memory[j]==0){
                return j;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int[] A={1,2,3,4,5,6,7,8,9,-1,-2,-3,100};
        System.out.println(findArrayMex(A,A.length));
    }
}
