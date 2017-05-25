package algorithm;

import java.util.Scanner;

public class PalindromicString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            System.out.println(getResult(string));
        }
    }

    public static String getResult(String str) {
        //将字符串变成字符数组
        char[] src = str.toCharArray();
        for (int i = 0; i < src.length + 1; i++) {
            char[] result = new char[src.length + 1];
            result[i] = '0';

            for (int j = 0; j < i; j++) {
                result[j] = src[j];
            }
            for (int k = i + 1; k < result.length; k++) {
                result[k] = src[k - 1];
            }
            result[result.length - 1 - i] = '0';
            int num = 0;
            for (int l = 0; l < result.length; l++) {
                if (result[l] == result[result.length - 1 - l]) {
                    num++;
                }

            }
            if (num == result.length) {
                return "YES";
            }
        }
        return "NO";
    }
}
/***
 *题目：判断一个字符串，能否加一个字符构成回文串
 *      回文串就是正读和反读都一样的字符串
 */

