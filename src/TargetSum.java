public class TargetSum {
    public static void main(String[] args) {
        int[] in = { 1};
        System.out.println(findTargetSumWays(in, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        rec(nums, 0, target, 0, ans);
        return ans[0];
    }

    static void rec(int[] nums, int index, int target, int currValue, int[] ans) {
        if(currValue == target && index == nums.length) ans[0] = ans[0] + 1;
        if(index >= nums.length) return;

        rec(nums, index + 1, target, currValue + nums[index], ans);
        rec(nums, index + 1, target, currValue - nums[index], ans);
    }

}
