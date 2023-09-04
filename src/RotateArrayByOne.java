import java.util.Arrays;

public class RotateArrayByOne {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int n = 5;
        rotate(a, n);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int arr[], int n)
    {
        int temp = arr[0];
        for(int i=0;i<arr.length;i++) {
            if(i + 1 < arr.length) {
                int t = arr[i + 1];
                arr[i + 1] = temp;
                temp = t;
            }
            if(i == arr.length - 1) {
                arr[0] = temp;
            }
        }
    }
}
