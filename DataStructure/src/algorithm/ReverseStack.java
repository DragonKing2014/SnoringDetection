package algorithm;


public class ReverseStack {
    public static int[] reverseStackRecursively(int[] stack, int top) {
        int[] reserveStack=new int[stack.length];
        for (int i=0;i<stack.length;i++){
            reserveStack[stack.length-1-i]=stack[i];
        }
        return reserveStack;
    }

    public static void main(String[] args){
        int[] stack={1,2,3,4,5,6,7};
        stack=reverseStackRecursively(stack,stack.length);

    }
}
