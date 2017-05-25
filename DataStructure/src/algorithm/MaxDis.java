package algorithm;

public class MaxDis {
    public static int maxDis(int array[]){
        int max=0;
        for (int i=0;i<=array.length-1;i++){
            for(int j=0;j<=i;j++){
                if (max<array[i]-array[j]){
                    max=array[i]-array[j];
                }
                if (max<array[j]-array[i]){
                    max=array[j]-array[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] array={122,22,2123,4,5,6,777,8,9,111};
        System.out.println(maxDis(array));

    }
}
