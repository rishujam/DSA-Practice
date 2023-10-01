import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class JumpGame2 {
    //Problem: https://leetcode.com/problems/jump-game-ii/

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0};
        System.out.println(optimised(arr));
    }

    // Time taking
    public static int jump(int[] nums) {
        int toReach = nums.length - 1;
        int i = 0;
        int jumps = 0;
        while(toReach != 0) {
            if(isPossible(nums, i, toReach)) {
                toReach = i;
                jumps++;
                i = 0;
            } else {
                i++;
            }
        }
        return jumps;
    }

    private static boolean isPossible(int[] arr, int currIndex, int toReach) {
        return arr[currIndex] >= toReach - currIndex;
    }

    //Optimised
    private static int optimised(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        jumpO(nums, 0, ans);
        return ans.get(0);
    }

    private static void jumpO(int[] nums, int jumps, ArrayList<Integer> a) {
        for(int i = 0; i<nums.length - 1;i++) {
            if(isPossible(nums, i, nums.length - 1)) {
                jumps++;
                int[] newArray = Arrays.copyOfRange(nums, 0, i + 1);
                if(newArray.length < 2) {
                    a.add(jumps);
                    break;
                }
                jumpO(newArray, jumps, a);
                break;
            }
        }
        a.add(-1);
    }
}
