package algorithm;

/**
 * 对于两个字符串A，B。请设计一个高效算法，找到B在A中第一次出现的起始位置。若B未在A中出现，则返回-1。
 * 给定两个字符串A和B，及它们的长度lena和lenb，请返回题目所求的答案
 */
public class StringPattern {
    public static int findAppearance(String A, int lena, String B, int lenb) {
        for (int i=0;i<=A.length()-1;i++){
            char a=A.charAt(i);
            char b=B.charAt(0);
            if (a==b){
                //循环次数为b的长度
                for (int j=i;j<=i+B.length()-1;j++){
                    a=A.charAt(j);
                    b=B.charAt(j-i);
                    if (a==b){
                        if (j-i==B.length()-1){
                            return i;
                        }
                        continue;
                    }else{
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(findAppearance("asdfghjjjjjjkl",9,"jkl",3));
    }
}
