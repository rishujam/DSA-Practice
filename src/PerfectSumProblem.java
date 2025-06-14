public class PerfectSumProblem {

    public static void main(String[] args) {
        int[] in = { 5, 2, 3, 10, 6, 8 };
        System.out.println(perfectSum(in, 10));
    }

    public static int perfectSum(int[] nums, int target) {
        if(nums.length == 0 && target > 0) return 0;
        int zeroCount = 0;
        if(target == 0) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    zeroCount++;
                }
            }
            return (int) Math.pow(2, zeroCount);
        }
//        int[][] dp = new int[nums.length][target + 1];
//        for(int i = 0; i < dp.length; i++) {
//            for(int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = -1;
//            }
//        }
        return rec(nums, target, 0, 0, false);
    }

    static int rec(int arr[], int sum, int index, int ans, boolean included) {
        if(sum == 0 && included) return ans + 1;
        if(sum < 0 || index >= arr.length) return 0;

        int left = rec(arr, sum - arr[index], index + 1, ans, true);
        int right = rec(arr, sum, index + 1, ans, false);
        return left + right;
    }


}
