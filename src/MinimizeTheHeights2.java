import java.util.Arrays;

public class MinimizeTheHeights2 {

    public static void main(String[] args) {
        int[] a = {1, 5, 8, 10};
        int n = 4;
        int k = 2;
        System.out.println(max(a, n, k));
    }

    public static int max(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int diff = arr[n - 1] - arr[0];
        int min, max;

        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            min = Math.min(arr[i] - k, arr[0] + k);

            diff = Math.min(diff, max - min);
        }
        return diff;
    }

}
