package algorithm;

import java.util.Stack;

/**
 * 判断一个有括号的表达式用括号是否合法
 */
public class ExpressionIsIllegal {
    public boolean chkLegal(String A) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        Stack<Character> s3=new Stack<>();
        for (int i=0;i<=A.length()-1;i++){
            Character c=A.charAt(i);
            switch (c){
                case '{':
                    s1.push(c);
                    break;
                case '[':
                    s2.push(c);
                    break;
                case '(':
                    s3.push(c);
                    break;
                case ')':
                    s3.pop();
                    break;
                case ']':
                    s2.pop();
                    break;
                case '}':
                    s1.pop();
                    break;
            }

        }

        return s1.isEmpty()&&s2.isEmpty()&&s3.isEmpty();
    }

    public static void main(String[] a){
        String correct="[a+b*(5-4)]*{x+b+b*(({1+2))}}";
        String wrong="{a+B+aaa+(a*b)+}";
        System.out.println(new ExpressionIsIllegal().chkLegal(correct));
        System.out.println(new ExpressionIsIllegal().chkLegal(wrong));

    }
}
