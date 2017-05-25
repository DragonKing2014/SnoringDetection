package algorithm;

import java.util.Scanner;

public class WordsInverse{
    public static void main(String[] a){
        Scanner input=new Scanner(System.in);
        String words=input.nextLine();
        /*将句子以空格分割为一个字符串数组*/
        String wordsArray[]=words.split(" ");
        for(int i=wordsArray.length-1;i>=0;i--){
            if (i==0){
                System.out.print(wordsArray[i]);
            }else{
                System.out.print(wordsArray[i]+" ");
            }
        }
    }
}
/*题目：
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
