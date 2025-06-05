import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            hs.put(nums[i], i);
        }
        for(int i = 0; i< nums.length; i++) {
            int mapIndex = hs.getOrDefault(target - nums[i], -1);
            if(mapIndex != -1 && mapIndex != i) {
                int[] out = new int[2];
                out[0] = i;
                out[1] = mapIndex;
                return out;
            }
        }
        return new int[2];
    }



}
