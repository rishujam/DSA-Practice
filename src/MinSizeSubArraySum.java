import java.util.Arrays;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] in = new int[5];
        in[0] = 1;
        in[1] = 2;
        in[2] = 3;
        in[3] = 4;
        in[4] = 5;
        System.out.print(minSubArrayLen(11, in));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int minLenWindow = Integer.MAX_VALUE;
        int currSum = 0;
        while(high < nums.length) {
            currSum += nums[high];
            high++;

            while(currSum >= target) {
                int currWindowSize = high - low;
                minLenWindow = Math.min(currWindowSize, minLenWindow);
                currSum -= nums[low];
                low++;
            }
        }
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }


}
