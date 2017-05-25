package algorithm.sort;

import java.util.Arrays;

/**
 * 排序算法，*****
 */
public class SimpleSort {
    //冒泡排序
    static void bubbleSort(int[] a){
        int temp;
        for (int i=1;i<a.length;i++){
            //第二层的循环次数比第一层少i次，因为这i个元素已经冒泡并已经有序
            for (int j=0;j<a.length-i;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                }
            }
        }
    }

    //插入排序(两个重复元素中，左边那个相当于给插入值留空)
    static void insertionSort(int[] a){
        int point;     //移动指针
        int temp;      //临时保存要插入的元素
        for (int i=1;i<a.length;i++){
            point=i-1;
            temp=a[i];
            while (point>=0 && a[point]>temp){
                a[point+1]=a[point];
                point--;
            }
            a[point+1]=temp;
        }
    }

    //选择排序
    static void selectSort(int[] a){
        int temp,index;
        //temp用于存储临时最小值，index用于存储临时最小值的下标
        for (int i=0;i<a.length-1;i++){
            index=i;
            temp=a[i];
            for (int j=i+1;j<a.length;j++){
                if (a[j]<temp){
                    temp=a[j];
                    index=j;
                }
            }
            a[index]=a[i];
            a[i]=temp;

        }
    }

    //快速排序(基于冒泡排序得到，不稳定)
    static void quickSort(int[] arr,int left,int right){
        //中间值和交换中间变量
        int f,t;
        //边界值
        int rtemp,ltemp;
        rtemp=right;
        ltemp=left;
        f=arr[left];     //计算分界值，通常选数组中的第一个，分界值在哪，那里就可以看做一个坑

        while (ltemp<rtemp){
            while(arr[ltemp]<f){
                ++ltemp;
            }
            while(arr[rtemp]>f){
                --rtemp;
            }
            if (ltemp<=rtemp){
                //交换坑里的值
                t=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=t;

                --rtemp;
                ++ltemp;
            }

        }

        if(rtemp==ltemp){
            ltemp++;
        }
        if (left<rtemp){
            quickSort(arr,left,ltemp-1);
        }
        if (ltemp<right){
            quickSort(arr,rtemp+1,right);
        }
    }

    //希尔排序(基于插入排序的优化，不稳定)
    static void shellSort(int[] a) {
        int point;
        int temp;
        //希尔排序的增量
        int r;

        for (r=a.length/2;r>=1;r=r/2) {
            for (int i = r; i < a.length; i++) {
                temp = a[i];
                //指针每次偏移r个单位
                point = i - r;
                while (point >= 0 && temp < a[point]) {
                    a[point + r] = a[point];
                    point -= r;
                }
                a[point + r] = temp;
            }

        }
    }



    public static void main(String[] args){
        int[] a={1,2,4,6,2,88,8,4,8,3,2,0,3,5,2,2,2};
        //selectSort(a);
        //quickSort(a,0,a.length-1);
        //shellSort(a);
        Arrays.sort(a);
    }
}
