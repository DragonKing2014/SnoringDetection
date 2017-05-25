package algorithm;

/**
 * 找出数组中出现次数超过数组长度一半的元素
 */
public class FindOverHalfEle {
    public static int getValue(int[] gifts, int n) {

        for (int i=0;i<gifts.length;i++){
            int count=0;
            for (int j=0;j<gifts.length;j++){
                if (gifts[j]==gifts[i]){
                    count++;
                }
            }
            if (count>gifts.length/2){
                return gifts[i];
            }
        }
        return 0;
    }

    public static int queckGet(int[] gifts,int n){
        int temp=gifts[0];
        int count=1;
        for (int i=1;i<gifts.length;i++){
            if (count==0){
                temp=gifts[i];
                count=1;
            }
            if (temp==gifts[i]){
                count++;
            }else{
                count--;
            }
        }

        int num=0;
        for(int j=0;j<gifts.length;j++){
            if (temp==gifts[j]){
                num++;
            }
        }
        return num>(gifts.length/2)?temp:0;
    }

    public static void main(String[] args){
        int[] array={1,2,3,4,1,1,1,1,1,1,1,5,5,5,5,5,6,6,6,66,1
                ,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,55,5,5,
                5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        System.out.println(getValue(array,array.length));
        System.out.println(getValue(array,array.length));
    }
}
