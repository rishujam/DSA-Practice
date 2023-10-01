public class JumpGame {
    //https://leetcode.com/problems/jump-game/description/

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++) {
            if(i > maxReach) return false;
            int reach = nums[i] + i;
            if(reach > maxReach) {
                maxReach = reach;
            }
        }
        return true;
    }
}
