package algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 顺序输出一个字符串中不重复的字符
 * 利用HashSet的非重复性来实现
 */
public class OutputUntiqueChar {
    public static void main(String[] a){
        Scanner input=new Scanner(System.in);
        //使用StringBuilder效率比较高
        while(input.hasNextLine()){
            StringBuilder sb=new StringBuilder();
            Set<Character> set=new HashSet<>();
            String inputString=input.nextLine();
            for(int i=0;i<inputString.length();i++){
                if (set.add(inputString.charAt(i))){
                    sb.append(inputString.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
