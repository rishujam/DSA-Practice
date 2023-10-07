import java.util.Arrays;

public class MergeSortedWithoutSpace {
    //Problem: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

    public static void main(String[] args) {
        long[] arr1 = {12, 42};
        long[] arr2 = {3, 4, 5, 28, 37, 42, 43, 46};
        ans(arr1, arr2);
        System.out.println("Array 1: "+ Arrays.toString(arr1) + "Array 2: " + Arrays.toString(arr2));
    }

    private static void ans(long[] arr1, long[] arr2) {
        int ind1 = arr1.length - 1;
        int ind2 = 0;
        while (ind1 > -1 && ind2 < arr2.length) {
            if(arr1[ind1] > arr2[ind2]) {
                long temp = arr1[ind1];
                arr1[ind1] = arr2[ind2];
                arr2[ind2] = temp;
                ind1--;
                ind2++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
