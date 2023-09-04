import java.util.Arrays;

public class KadanesAlgo {

    public static void main(String[] args) {
        int[] a = {-4,-2,-3,-1};
        int n = 5;
        System.out.println(kadanes(a, n));
    }

    public static int kadanes(int[] arr, int n) {
        int currSum = 0;
        int maxSum = arr[0];
        for(int i = 0;i<arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }


}
