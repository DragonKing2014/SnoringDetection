package algorithm.search;

/**
 * 查找算法
 */

//二分查找
public class SimpleSearch {
    static int binarySearch(int[] a,int n,int x){
        int low=0;
        int high=n-1;
        int mid;

        while(low<=high){
            mid=(low+high)/2;

            if (a[mid]==x){
                return mid;
            }else if(a[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }

    //顺序查找
    static int orderSearch(int[] a,int n,int x){
        for(int i=1;i<n;i++){
            if (a[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] a={1,2,3,4,5,6,7,8,9,11};
        System.out.println(binarySearch(a,a.length,8));
        System.out.println(orderSearch(a,a.length,8));
    }
}
