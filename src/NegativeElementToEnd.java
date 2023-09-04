import java.util.Arrays;

public class NegativeElementToEnd {

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        int n = 8;
        segregateElements(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregateElements(int[] arr, int n)
    {
        int[] a = new int[arr.length];
        int j = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] >= 0) {
                a[j] = arr[i];
                arr[i] = Integer.MAX_VALUE;
                j++;
            }
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < 0) {
                a[j] = arr[i];
                j++;
            }
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = a[i];
        }
    }
}
