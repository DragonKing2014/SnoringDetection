package algorithm;

/**
 *
 */
public class FormatString {
    public static String formatString(String A, int n, char[] arg, int m) {
        //count用于统计有多少个占位符
        int count=0;
        String output="";
        for (int i=0;i<=A.length()-1;i++){
            if (A.charAt(i)=='%'&&A.charAt(i+1)=='s'&&i!=A.length()){
                output=output+arg[count];
                count++;
                continue;
            }
            if (A.charAt(i)=='s'&&A.charAt(i-1)=='%'&&i!=0){
                continue;
            }
            output=output+A.charAt(i);
        }

        if (arg.length>count){
            for (int j=count;j<=arg.length-1;j++){
                output=output+arg[j];
            }
        }

        return output;
    }

    public static void main(String[] args){
        String input="12%%%%%s123%sfghjk%saaa";
        char[] arg={'A','B','C','D','F'};
        System.out.println(formatString(input,input.length(),arg,arg.length));
    }
}
