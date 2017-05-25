package algorithm;

public class BubbleSort {

    static final int SIZE=10;
    public static void selectSort(int[] array){
        int index,temp;
        for (int i = 0; i < array.length-1; i++) {
            index=i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[index]) {
                    //index最终将是这次遍历中最小元素的下标
                    index=j;
                }
            }

            //交换两个数，使最小的元素始终在前面
            if (index!=i) {
                temp=array[i];
                array[i]=array[index];
                array[index]=temp;
            }
            System.out.print("第"+i+"步排序结果是：");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]+"  ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[] sortArray=new int[SIZE];
        int i;

        for(i=0;i<sortArray.length;i++){
            //初始化数组为随机数序列
            sortArray[i]=(int)(100+Math.random()*(100+1));
        }

        System.out.println("排序前的数组为：");
        for(i=0;i<sortArray.length;i++){
            System.out.print(sortArray[i]+"\t");
        }
        System.out.print("\n\n");

        selectSort(sortArray);

        System.out.println();
        System.out.println("排序后的数组为：");
        for(i=0;i<sortArray.length;i++){
            System.out.print(sortArray[i]+"\t");
        }
        System.out.println("\n");
    }
}
