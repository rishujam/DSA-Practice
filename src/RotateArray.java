import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] in = { 1,2,3,4,5,6,7 };
        rotate(in, 3);
        System.out.println(Arrays.toString(in));
    }

    public static void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        for(int i = 1; i <= rotations; i++) {
            int prev = nums[0];
            for(int j = 1; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
            nums[0] = prev;
        }
    }

}
