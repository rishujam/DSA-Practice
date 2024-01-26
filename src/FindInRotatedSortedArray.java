import java.util.Arrays;

public class FindInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {5,1,2,3,4};
        int target = 1;
        System.out.println(search(a, target));
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target == nums[i]) {
                return i;
            }
            if(target == nums[j]) {
                return j;
            }
            if(nums[i] < nums[mid] && !(target > nums[mid] && target <=  nums[j])) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
