package algorithm;

import java.util.Scanner;

public class IsPalindromicString {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String string=input.next();
            //将字符串转化为字符数组
            char[] charArray=string.toCharArray();
            //保存是否出现正确结果
            boolean isPa=false;

            //每一次循环，都构建一个新数组，使数组第n位空余，其余的位用原数组填补
            for(int n=0;n<=charArray.length;n++){

                char[] newCharArray=new char[charArray.length+1];
                char temp='a';
                //构造新字符串
                newCharArray[n]=temp;
                for(int j=0;j<n;j++){
                    newCharArray[j]=charArray[j];
                }
                for(int k=n+1;k<=newCharArray.length-1;k++){
                    newCharArray[k]=charArray[k-1];
                }
                newCharArray[n]=newCharArray[newCharArray.length-1-n];

                //用来判断是否是回文串的字符串
                String newString=new String(newCharArray);
                String newStringInverse="";
                for (int m=newString.length()-1;m>=0;m--){
                    newStringInverse+=newString.charAt(m);
                }
                if (newString.equals(newStringInverse)){
                    isPa=true;
                    break;
                }else{
                    continue;
                }

            }

            if (isPa){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}

/**
 * 题目：判断一个字符串是否是回文串
 */
