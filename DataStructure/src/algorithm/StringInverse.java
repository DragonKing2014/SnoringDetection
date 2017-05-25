package algorithm;

import java.util.Scanner;

/**
 * 题目：将一个字符串反转
 */
public class StringInverse {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String string=input.nextLine();

        //正序输出
        for(int i=0;i<=string.length()-1;i++){
            System.out.print(string.charAt(i));
        }

        System.out.print("\n");

        //反序输出
        for (int i=string.length()-1;i>=0;i--){
            System.out.print(string.charAt(i));
        }
    }
}
