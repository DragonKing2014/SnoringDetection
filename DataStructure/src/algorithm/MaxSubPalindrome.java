package algorithm;

/**
 * 求最长回文子串的长度
 */
public class MaxSubPalindrome {
    public static int getLongestPalindrome(String A, int n) {
        int max=0;
        for(int i=0;i<A.length()-1;i++){
            int left=i;
            int right=i;
            //从最小的“奇数回文串”开始扩展搜索，注意边界条件
            while(left-1>=0 && right+1<n && A.charAt(left-1)==A.charAt(right+1)){
                left--;
                right++;
            }
            max=Math.max(max,right-left+1);
            left=i;
            right=i+1;
            //从最小的“偶数回文串”开始扩展搜索，注意边界条件
            while(left>=0 && right<n && A.charAt(left)==A.charAt(right)){
                left--;
                right++;
            }
            max=Math.max(max,right-left-1);
        }
        return max;
    }

    public static void main(String[] args){
        String string="asdfhkhfaaaafdakfajskf";
        int max=getLongestPalindrome(string,string.length());
        System.out.println(max);
    }
}
