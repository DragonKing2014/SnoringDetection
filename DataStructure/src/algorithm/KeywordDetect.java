package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有一个字符串列表，和一个关键词列表，
 * 请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 * 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，
 * 请返回一个排好序的含关键词的字符串序号的列表。保证所有字符串长度小于等于100，
 * 关键词个数小于等于100，字符串个数小于等于200。保证所有字符串全部由小写英文字符组成。
 * 若不存在含关键字的字符串，请返回一个只含-1的数组。
 */
public class KeywordDetect {
    public static int[] containKeyword(String[] A, int n, String[] keys, int m) {
        List<Integer> outputList=new ArrayList<>();
        for (int i=0;i<=A.length-1;i++){
            for (int j=0;j<=keys.length-1;j++){
                if (A[i].contains(keys[j])){
                    outputList.add(i);
                    break;
                }
            }
        }

        int[] output=new int[outputList.size()];
        for(int k=0;k<=outputList.size()-1;k++){
            output[k]=outputList.get(k);
        }

        if (output.length==0){
            output=new int[1];
            output[0]=-1;
        }
        return output;
    }

    public static void main(String[] args){
        String[] input={"nowcoder","hello","now"};
        String[] keys={"coder","now"};
        int[] output=containKeyword(input,input.length,keys,keys.length);
    }
}