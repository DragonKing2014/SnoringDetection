package algorithm;

/**
 * 现定义数组单调和为所有元素i的f(i)值之和。
 * 这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。请设计一个高效算法，计算数组的单调和。
 */
public class MonoSum {
    public int calcMonoSum(int[] A, int n) {
        int sum=0;
        for (int i=0;i<=A.length-1;i++){
            sum=sum+f(A,i);
        }
        return sum;
    }

    public int f(int[] A,int i){
        int sum=0;
        //i是数组的某个下标
        if (i==0){
            return sum;
        }
        for (int j=0;j<i;j++){
            if (A[j]<=A[i]){
                sum=sum+A[j];
            }
        }
        return sum;
    }

    public static void main(String[] a){
        MonoSum monoSum=new MonoSum();
        int A[]={1,2,3,4,5,6,7};
        System.out.println(monoSum.calcMonoSum(A,A.length));
    }
}
