import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] a = {5,4,3,1,2};
        nextPermutation(a);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        int i1 = i - 1;
        int max = 0;
        boolean found = false;
        while(i1 > -1) {
            if(nums[i] > nums[i1]) {
                found = true;
                max = Math.max(max, nums[i]);
                break;
            }
            i--;
            i1--;
        }
        if(found) {
            int i2 = getClosestBiggerNo(Arrays.copyOfRange(nums, i, nums.length), nums[i1], max) + i;
            int temp = nums[i2];
            nums[i2] = nums[i1];
            nums[i1] = temp;
            Arrays.sort(nums, i1 + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    static int getClosestBiggerNo(int[] arr, int num, int max) {
        int closestBiggerNo = max;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > num && arr[i] < closestBiggerNo) {
                closestBiggerNo = arr[i];
                index = i;
            }
        }
        return index;
    }

}
