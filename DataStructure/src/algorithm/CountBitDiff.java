package algorithm;

/**
 * @author
 * 题目：两个int32整数m和n的二进制表达，有多少个位(bit)不同
 */
public class CountBitDiff {
    /**
     *
     * @param m
     * @param n
     * @return int
     */
    public static int countBitDiff(int m,int n){
        //将m和n进行或运算后输出字符串类型的二进制数据
        String diff=Integer.toBinaryString(m^n);
        int count=0;
        for(int i=0;i<diff.length();i++){
            if (diff.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int result=countBitDiff(0b0101011,0b11111111);
        System.out.println(result);
    }
}
