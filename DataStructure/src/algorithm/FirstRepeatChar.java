package algorithm;

/**
 * @author wang.jl
 * 题目：给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 */
public class FirstRepeatChar {
    /**
     * @param A 给定字符串
     * @param n 字符串长度n
     * @return 首个重复的字符
     */
    public static char findFirstRepeat(String A, int n) {
        int len=A.length();
        //数组长度为ASCII码的个数
        int[] count=new int[256];
        for(int i=0;i<len;i++){
            //检测到有标记，证明它已经出现过
            if(count[A.charAt(i)]==1)
                return A.charAt(i);
            //每出现一个不一样的字符，就以这个字符对应的ASCII码为下标的数组元素加一，相当于做一个标记
            count[A.charAt(i)]++;
        }
        return (Character) null;
    }

    public static void main(String[] args){
        System.out.print(findFirstRepeat("asdsacvbjnkmasd",6));
    }
}
