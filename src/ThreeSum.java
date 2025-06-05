import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        int[] input = new int[6];
        input[0] = -1;
        input[1] = 0;
        input[2] = 1;
        input[3] = 2;
        input[4] = -1;
        input[5] = -4;
        List<List<Integer>> out = threeSum(input);
        for(int i = 0; i < out.size(); i++) {
            List<Integer> x = out.get(i);
            for(int j = 0; j < x.size(); j++) {
                System.out.print(x.get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
        for(int i = 0; i< nums.length; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
            for(int j = 0; j < nums.length; j++) {
                int currValue = hs.getOrDefault(nums[j], -1);
                if(currValue == -1) {
                    hs.put(nums[j], 1);
                } else {
                    currValue++;
                    hs.put(nums[j], currValue);
                }
            }
            ArrayList<Integer> subOutput = twoSum(hs, nums, target);
            if(subOutput.size() == 2) {
                subOutput.add(nums[i]);
                out.add(subOutput);
            }
        }
        return out.subList(0, out.size());
    }

    public static ArrayList<Integer> twoSum(HashMap<Integer, Integer> hs, int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int count = hs.getOrDefault(target - nums[i], -1);
            if(count > 1) {
                ArrayList<Integer> out = new ArrayList<Integer>();
                out.add(nums[i]);
                out.add(target - nums[i]);
                count--;
                hs.put(target - nums[i], count);
                return out;
            }
        }
        return new ArrayList();
    }

}
