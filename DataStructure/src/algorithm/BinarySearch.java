package algorithm;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        for (int i=0;i<=A.length-1;i++){
            if (A[i]==val){
                return i;
            }
        }
        return -1;
    }
}