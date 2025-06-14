public class EqualSumPartition {

    public static void main(String[] args) {
        int[] in = { 100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        System.out.println(canPartition(in));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i< nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for(int i = 0 ; i < dp.length ;i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(nums, 0, 0, target, dp);
    }

    public static boolean rec(int[] nums, int sum, int index, int target, int[][] dp) {
        if(sum == target) return true;
        if(index >= nums.length || sum > target) return false;
        if(dp[index][sum] != -1) {
            if(dp[index][sum] == 0) {
                return false;
            } else if(dp[index][sum] == 1) {
                return true;
            }
        }
        boolean left = rec(nums, sum + nums[index], index + 1, target, dp);
        if(left) {
            dp[index][sum] = 1;
            return true;
        }
        boolean right = rec(nums, sum, index + 1, target, dp);
        if(right) {
            dp[index][sum] = 1;
        } else {
            dp[index][sum] = 0;
        }
        return dp[index][sum] == 1;
    }

}
